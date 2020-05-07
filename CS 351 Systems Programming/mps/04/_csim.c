#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <getopt.h>
#include <stdint.h>
#include <stdbool.h>

#include "cachelab.h"

// If -h is passed as an option
void printHelp() {
	printf("Usage: ./csim-ref [-hv] -s <num> -E <num> -b <num> -t <file>\
Options:\
  -h         Print this help message.\
  -v         Optional verbose flag.\
  -s <num>   Number of set index bits.\
  -E <num>   Number of lines per set.\
  -b <num>   Number of block offset bits.\
  -t <file>  Trace file.\
\
Examples:\
  linux>  ./csim-ref -s 4 -E 1 -b 4 -t traces/yi.trace\
  linux>  ./csim-ref -v -s 8 -E 2 -b 4 -t traces/yi.trace\
");
	exit(0);
}

// If -v is passed as an option
bool verbose = false;

// Determined from the command line arguments
int index_bits = 0;
int associativity = 0;
int block_bits = 0;

// The cache implementation

struct cache_line {
	bool valid;
	uint64_t tag;
	uint64_t timestamp; // line->timestamp = time++
	uint64_t val;
};

struct cache_set {
	struct cache_line *lines;
};

typedef struct cache {
	uint64_t time;
	struct cache_set *sets;
	
	int hit_count;
	int miss_count;
	int eviction_count;
} cache_t;

// Functions for manipulating the address

uint64_t get_index(uint64_t addr) {
	uint64_t mask = (1 << index_bits) - 1;
	mask <<= block_bits;
	uint64_t index = addr & mask;
	index >>= block_bits;
	return index;
}

uint64_t get_tag(uint64_t addr) {
	uint64_t tag = addr >> (block_bits + index_bits);
	return tag;
}

uint64_t get_block_offset(uint64_t addr) {
	uint64_t mask = (1 << block_bits) - 1;
	return addr & mask;
}

cache_t *create_cache() {
	struct cache *cache = malloc(sizeof(struct cache));
	cache->time = 0;
	uint64_t n_sets = 1 << index_bits;
	cache->sets = malloc(sizeof(void*) * (1 << n_sets));
	
	for (int i = 0; i < n_sets; i++) {
		cache->sets[i].lines = malloc(sizeof(struct cache_line) * associativity);
		
		for(int j = 0; j < associativity; j++) {
			cache->sets[i].lines[j].valid = false;
		}
	}
	
	return cache;
}

void printCache(cache_t *c) {
	uint64_t n_sets = 1 << index_bits;
	printf("\nSet : Valid : Tag : Time\n");

	for(int i = 0; i < n_sets; i++) {
		
		for(int j = 0; j < associativity; j++) {
			struct cache_line l = c->sets[i].lines[j];
			printf("%d : %d : %lu : %lu\n", i, l.valid, l.tag, l.timestamp);
		}
	}
}

void cache_load(cache_t *cache, uint64_t addr) {
	uint64_t tag = get_tag(addr);
	uint64_t set_index = get_index(addr);
	uint64_t block_offset = get_block_offset(addr);
	
	if(verbose) {
		printf("tag=%lx index=%lx offset=%lx\n", tag, set_index, block_offset);
	}
	
	struct cache_set *set = &cache->sets[set_index];
	bool did_hit = false;
	
	for(int j = 0; j < associativity; j++) {
		struct cache_line *line = &set->lines[j];
		
		if(!line->valid) {
			continue;
		}
		
		if(line->tag == tag) {
			did_hit = true;
			line->timestamp = cache->time++;
			cache->hit_count++;
			break;
		}
	}
	
	if(!did_hit) {
		cache->miss_count++;
		
		struct cache_line *evc = &set->lines[0]; // eviction candidate
		bool found_unused = false;
		
		for(int j = 0; j < associativity; j++) {
			struct cache_line *line = &set->lines[j];
			
			if(!line->valid) {
				// no eviction necessary
				line->valid = true;
				line->tag = tag;
				line->timestamp = cache->time++;
				found_unused = true;
				break;
			}
			else if(line->timestamp <= evc->timestamp) {
				evc = line;
			}
		}
		
		if(!found_unused) {
			cache->eviction_count++;
			evc->timestamp = cache->time++;
			evc->tag = tag;
		}
	}
}

void cache_store(cache_t *cache, uint64_t addr) {
	cache_load(cache, addr);
}

void cache_modify(cache_t *cache, uint64_t addr) {
	cache_load(cache, addr);
	cache_store(cache, addr);
}

/////////////////////////////////////////////////
//                                             //
//                START PROGRAM                //
//                                             //
/////////////////////////////////////////////////

int main(int argc, char *argv[])
{	
	// Used for reading the arguments and opening the trace file
	char buf[200];
	char opt;
	char *trace;
	
	// Used for parsing each line of the trace file
	uint64_t addr;
	unsigned int size;
	char operation, tmp;
	
	// Parse the command line options
	while((opt = getopt(argc, argv, "h:v:s:E:b:t:")) != -1) {
		switch(opt) {
			case 'h':
				printHelp();
				break;
			case 'v':
				verbose = true;
				break;
			case 's':
				index_bits = atoi(optarg);
				break;
			case 'E':
				associativity = atoi(optarg);
			case 'b':
				block_bits = atoi(optarg);
				break;
			case 't':
				trace = optarg;
				break;
		}
	}
	
	// Create the cache
	struct cache *cache = create_cache();
	cache->sets[0].lines[0].valid = false; // random so it does not complain

	// Open the specified trace file
	FILE *fp = fopen(trace ,"r");
	
	// Iterate over each line in the trace file
	while(fgets(buf, sizeof(buf), fp)) {
	
		sscanf(buf, "%c%c %lx,%u", &tmp, &operation, &addr, &size);
		
		switch(operation) {
			case 'L':
				cache_load(cache, addr);
				break;
			case 'S':
				cache_store(cache, addr);
				break;
			case 'M':
				cache_modify(cache, addr);
				break;
		}
	}

  printSummary(cache->hit_count, cache->miss_count, cache->eviction_count);
  return 0;
}
