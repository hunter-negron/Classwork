#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	if(argc < 3) {
		printf("Usage: %s STRING1 STRING2\n", argv[0]);
		printf("       %s -d STRING\n", argv[0]);
		exit(1);
	}
	
	const int SIZE = 256; // size of the maximum line to read

	if(strcmp(argv[1], "-d") == 0) {
		// Deletion
		int skip = 0;
		// can't use SIZE because "a variable size array can't be initialized"
		char line[256] = {0};
		
		while(fgets(line, SIZE, stdin) != NULL) {		
			// Loop over the entire inputed string
			for(int i = 0; i < SIZE; i++) {
				// Check each character against the provided deletion string
				for(int j = 0; j < strlen(argv[2]); j++) {
					// If a match is found, skip the current character and break
					if(line[i] == argv[2][j]) {
						skip = 1;
						break;
					}
				}
				
				if(skip == 0 && line[i] != '\0') {
					printf("%c", line[i]);
				}
				else {
					skip = 0;
				}
			}
			// Reinititalize the array
			for(int i=0;i<SIZE;i++)
				line[i]='\0';
		}
	}
	else if(strlen(argv[1]) == strlen(argv[2])) {
		// Replacement
		int printed = 0;
		// can't use SIZE because "a variable size array can't be initialized"
		char line[256] = {0};
		
		while(fgets(line, SIZE, stdin) != NULL) {
			for(int i = 0; i < SIZE; i++) {				
				// Check each character against the provided translation strings
				for(int j = 0; j < strlen(argv[1]); j++) {
					// If a match is found, print the new character and break
					if(line[i] == argv[1][j]) {
						printf("%c", argv[2][j]);
						printed = 1;
						break;
					}
				}				
				// Print out the original character if necessary
				if(!printed && line[i] != '\0') {
					printf("%c", line[i]);
				}
				else {
					printed = 0;
				}	
			}
			// Reinititalize the array
			for(int i=0;i<SIZE;i++)
				line[i]='\0';
		}
	}
	else {
		printf("STRING1 and STRING2 must have the same length\n");
		exit(1);
	}
		
	//free(line); // Must be freed because of how getline() works
 	return 0;
}
