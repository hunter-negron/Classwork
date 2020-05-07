#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	// Check arguments
	if(argc < 2) {
		printf("Usage: %s FILENAME\n", argv[0]);
		exit(1);
	}
	
  	// Open file
	FILE *text = fopen(argv[1], "r");
  
  	// Make the file exists and is okay
	if(text == NULL) {
		printf("Failure to read file.\n");
		exit(1);
	}
	
	// Get each character
	char c = fgetc(text); // current
	char n = c; // next
	while(n != EOF) {
		int count = 0;
		while(n == c) {
			if(n != EOF) {
				count++;
			}
			else {
				break;
			}
			
			n = fgetc(text);
		}
		
		fwrite(&count, sizeof(int), 1, stdout);
		fputc(c, stdout);
		c = n;
	}

	return 0;
}