#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	// Check arguments
	if(argc < 2) {
		printf("Usage: %s FILENAME\n", argv[0]);
		exit(1);
	}
	
  	// Open file
	FILE *zip = fopen(argv[1], "r");
  
  	// Make the file exists and is okay
	if(zip == NULL) {
		printf("Failure to read file.\n");
		exit(1);
	}
	
	// Get the first quantity
	int count;
	size_t stat = fread(&count, sizeof(int), 1, zip);
		
	// Check to make sure it's not EOF, then print the appropriate amount of characters
	while(stat != 0) {
		char c;
		fread(&c, sizeof(char), 1, zip);
		
		for(int i = 0; i < count; i++) {
			fputc(c, stdout);
		}
		
		stat = fread(&count, sizeof(int), 1, zip);
	}
	
	return 0;
}
