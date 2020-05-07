/* 
 * trans.c - Matrix transpose B = A^T
 *
 * Each transpose function must have a prototype of the form:
 * void trans(int M, int N, int A[N][M], int B[M][N]);
 *
 * A transpose function is evaluated by counting the number of misses
 * on a 1KB direct mapped cache with a block size of 32 bytes.
 */ 
#include <stdio.h>
#include "cachelab.h"

int is_transpose(int M, int N, int A[N][M], int B[M][N]);

void trans(int M, int N, int A[N][M], int B[M][N]);
/* 
 * transpose_submit - This is the solution transpose function that you
 *     will be graded on for Part B of the assignment. Do not change
 *     the description string "Transpose submission", as the driver
 *     searches for that string to identify the transpose function to
 *     be graded. 
 */
char transpose_submit_desc[] = "Transpose submission";
void transpose_submit(int M, int N, int A[N][M], int B[M][N])
{
	if(M == 32) { // 32x32
		int t = 8;
	
		int tmp[t][t];
		for(int ii = 0; ii < M; ii += t) {
			for(int jj = 0; jj < N; jj += t) {
				for(int i = 0; i < t; i++) {
					for(int j = 0; j < t; j++) {
						tmp[i][j] = A[ii+i][jj+j];
					}
				}
				
				for(int i = 0; i < t; i++) {
					for(int j = 0; j < t; j++) {
						B[jj+j][ii+i] = tmp[i][j];
					}
				}
			}
		}
	}
	else if(M == 64) { // 64x64
		int t = 4;
	
		int tmp[t][t];
		for(int ii = 0; ii < M; ii += t) {
			for(int jj = 0; jj < N; jj += t) {
				for(int i = 0; i < t; i++) {
					for(int j = 0; j < t; j++) {
						tmp[i][j] = A[jj+j][ii+i];
					}
				}
				
				for(int i = 0; i < t; i++) {
					for(int j = 0; j < t; j++) {
						B[ii+i][jj+j] = tmp[i][j];
					}
				}
			}
		}
	}
	else { // 61x67
	
		// Assuming t does not divide M or N
		int t = 6;
	
		int tmp[t][t];
		for(int ii = 0; ii+t < M; ii += t) {
			for(int jj = 0; jj+t < N; jj += t) {
				for(int i = 0; i < t; i++) {
					for(int j = 0; j < t; j++) {
						tmp[i][j] = A[jj+i][ii+j];
					}
				}
				
				for(int i = 0; i < t; i++) {
					for(int j = 0; j < t; j++) {
						B[ii+j][jj+i] = tmp[i][j];
					}
					
				}
			}
		}
		
		// Finish off M
		int then;
		for(int i = 0; i < N; i++) {
			for(int j = M-(M%t); j < M; j++) {
			    then = A[i][j];
			    B[j][i] = then;
			}
		}
		
		// Finish of N
		for(int i = N-(N%t); i < N; i++) {
			for(int j = 0; j < M; j++) {
			    then = A[i][j];
			    B[j][i] = then;
			}
		}
	}
}

/* 
 * You can define additional transpose functions below. We've defined
 * a simple one below to help you get started. 
 */ 

/* 
 * trans - A simple baseline transpose function, not optimized for the cache.
 */
char trans_desc[] = "Simple row-wise scan transpose";
void trans(int M, int N, int A[N][M], int B[M][N])
{
    int i, j, tmp;

    for (i = 0; i < N; i++) {
        for (j = 0; j < M; j++) {
            tmp = A[i][j];
            B[j][i] = tmp;
        }
    }
}

/*
 * registerFunctions - This function registers your transpose
 *     functions with the driver.  At runtime, the driver will
 *     evaluate each of the registered functions and summarize their
 *     performance. This is a handy way to experiment with different
 *     transpose strategies.
 */
void registerFunctions()
{
    /* Register your solution function */
    registerTransFunction(transpose_submit, transpose_submit_desc); 

    /* Register any additional transpose functions */
    //registerTransFunction(trans, trans_desc); 

}

/* 
 * is_transpose - This helper function checks if B is the transpose of
 *     A. You can check the correctness of your transpose by calling
 *     it before returning from the transpose function.
 */
int is_transpose(int M, int N, int A[N][M], int B[M][N])
{
    int i, j;

    for (i = 0; i < N; i++) {
        for (j = 0; j < M; ++j) {
            if (A[i][j] != B[j][i]) {
                return 0;
            }
        }
    }
    return 1;
}

