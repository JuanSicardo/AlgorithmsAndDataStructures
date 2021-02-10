/*Author: Juan Antonio Sicardo Contreras
* Date: Fall of 2019
* Description: This program makes the multiplication of two matrixes. First, the program reads
* from the user the sizes of the two matrixes that are going to be multiplied. Then, the program
* reads from the input each element of both matrixes and finally it outputs the result.
*/

#include <stdio.h>
#include <stdlib.h>

int readInt();
float readFloat();
void readMatrix();
void printMatrix();
float** createMatrix();
float** multiplyMatrix();

int main() {
	int rowsA, columnsA, columnsB;	//Sizes of the matrixes
	float **A, **B;					//Matrixes

	printf("\n--Please enter the number of rows of matrix A: ");
	rowsA = readInt();

	printf("\n--Please enter the number of columns of matrix A: ");
	columnsA = readInt();

	printf("\n--Please enter the number of columns of matrix B: ");
	columnsB = readInt();

	printf("\n--Please enter the elements of matrix A in order [row][column]:\n\n");
	A = createMatrix(rowsA, columnsA);
	readMatrix(A, rowsA, columnsA);

	printf("\n--Please enter the elements of matrix B in order [row][column]:\n\n");
	B = createMatrix(columnsA, columnsB);
	readMatrix(B, columnsA, columnsB);

	printf("\n--Matrix A:\n\n");
	printMatrix(A, rowsA, columnsA);

	printf("\n--Matrix B:\n\n");
	printMatrix(B, columnsA, columnsB);

	printf("\n\n--The result of A x B is:\n\n");
	printMatrix(multiplyMatrix(A,B,rowsA,columnsA,columnsB), rowsA, columnsB);

	return 0;
}

//Returns an integer read from console
int readInt() {
	int n;
	scanf("%d", &n);
	return n;
}

//Returns a float read from console
float readFloat() {
	float n;
	scanf("%f", &n);
	return n;
}

//Allocates memory for a matrix
float** createMatrix(int rows, int columns) {
	int i, j;
	float **M;

	M = (float **) malloc(rows*sizeof(float *));
	for(i = 0; i < rows; i++)
		M[i] = (float *) malloc(columns*sizeof(float));

	return M;
}

//Reads from console each element of a matrix already allocated in memory
void readMatrix(float **M, int rows, int columns) {
	int i, j;

	for(i = 0; i < rows; i++)
		for(j = 0; j < columns; j++) {
			printf("[%d][%d]: ", i + 1, j + 1);
			M[i][j] = readFloat();
		}
}

//Prints a matrix to console using two decimal precision floats.
void printMatrix(float **M, int r, int c) {
	int i, j;

	for(i = 0; i < r; i++) {
		for(j = 0; j < c; j++)
			printf("%8.2f ", M[i][j]);

		printf("\n");
	}
}

//Does the multiplication of the matrix. Note: We assume that the number of columns of matrix A equal the number
//of rows of matrix B.
//O(rowsA * columnsA * columnsB)
float** multiplyMatrix(float **A, float **B, int rowsA, int columnsA, int columnsB) {
	int i, j, k;

	float **M = createMatrix(rowsA, columnsB);

	for(i = 0; i < rowsA; i++)
		for(j = 0; j < columnsB; j++) {
			M[i][j] = 0;
			for(k = 0; k < columnsA; k++)
				M[i][j] += A[i][k] * B[k][j];
		}

	return M;
}
