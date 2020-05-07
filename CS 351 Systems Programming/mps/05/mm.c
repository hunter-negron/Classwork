#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include <unistd.h>
#include "mm.h"
#include "memlib.h"

#define ALIGNMENT 8

#define ALIGN(size) (((size) + (ALIGNMENT-1)) & ~0x7)

#define SIZE_T_SIZE (ALIGN(sizeof(size_t)))

#define MIN_BLK_SIZE (SIZE_T_SIZE + ALIGN(1))


void *find_fit(size_t);
void dump_heap();
size_t round_up(size_t);
void coalesce(void *);


int mm_init(void)
{
    return 0;
}


void *mm_malloc(size_t size)
{
    size_t blk_size = ALIGN(round_up(size) + SIZE_T_SIZE*2);
    size_t *header = find_fit(blk_size);
    if(header) {
        if(*header - blk_size >= MIN_BLK_SIZE) {
            // update next block's header
            *(size_t *)((char *)header + blk_size) = *header - blk_size;
            // update next block's footer
            *(size_t *)((char *)header + *header - SIZE_T_SIZE) = *header - blk_size;
            // update my header
            *header = blk_size;
        }
    } else {
        header = mem_sbrk(blk_size);
        if(header == (void *)-1) {
            return NULL;
        } else {
            *header = blk_size;
        }
    }
    // copy my header into my footer
    *(size_t *)((char *)header + *header - SIZE_T_SIZE) = *header | 1;
    *header |= 1;
    return (char *)header + 8;
}


void *find_fit(size_t size) {
    size_t *header = mem_heap_lo();
    while ((void *)header < mem_heap_hi()) {
        if(!(*header & 1) && *header >= size) {
            return header;
        }
        header = (size_t *)((char *)header + (*header & ~1L));
    }
    return NULL;
}


// performs simple optimization for binary* traces
size_t round_up(size_t size)
{
    if(size > (1L << 9)) {
        return size;
    } else {
        size_t nsize = 1;
        while (nsize < size) {
            nsize <<= 1;
        }
        return nsize;
    }
}


void mm_free(void *ptr)
{
    size_t *header = ptr - SIZE_T_SIZE;
    *header &= ~1L;
    *(size_t *)((char *)header + *header - SIZE_T_SIZE) = *header;
    coalesce(header);
}


void coalesce(void *hp)
{
    size_t size = *(size_t *)hp;
    void *prev_fp = hp - SIZE_T_SIZE,
         *next_hp = hp + size,
         *prev_hp,
         *next_fp,
         *final_hp = hp,
         *final_fp = hp + size - SIZE_T_SIZE;
         
    if (prev_fp < mem_heap_lo()) {
        prev_hp = prev_fp = NULL;
    } else {
        prev_hp = prev_fp - (*(size_t *)prev_fp & ~1L) + SIZE_T_SIZE;
    }
    
    if (next_hp > mem_heap_hi()) {
        next_hp = next_fp = NULL;
    } else {
        next_fp = next_hp + (*(size_t *)next_hp & ~1L) - SIZE_T_SIZE;
    }
    
    if(prev_hp && !(*(size_t *)prev_hp & 1)) {
        size += *(size_t *)prev_hp;
        final_hp = prev_hp;
    }
    
    if (next_hp && !(*(size_t *)next_hp & 1)) {
        size += *(size_t *)next_hp;
        final_fp = next_fp;
    }
    
    *(size_t *)final_hp = size;
    *(size_t *)final_fp = size;
}


void *mm_realloc(void *ptr, size_t size)
{
    //simple optimization if block is at end of heap
    size_t *header = ptr - SIZE_T_SIZE;
    if ((char *)header + (*header & ~1L) > (char *)mem_heap_hi()) {
        size_t blk_size = ALIGN(size + SIZE_T_SIZE*2);
        mem_sbrk(blk_size - (*header & ~1L));
        *header = blk_size | 1;
        *(size_t *)((char *)header + blk_size - SIZE_T_SIZE) = blk_size | 1;
        return ptr;
    } else {
        void *oldptr = ptr;
        void *newptr;
        size_t copySize;
        newptr = mm_malloc(size);
        if (newptr == NULL)
            return NULL;
        copySize = *(size_t *)((char *)oldptr - SIZE_T_SIZE);
        if (size < copySize)
            copySize = size;
        memcpy(newptr, oldptr, copySize);
        mm_free(oldptr);
        return newptr;
    }
}
