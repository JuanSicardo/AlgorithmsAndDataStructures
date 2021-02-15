/*Author: Juan Antonio Sicardo Contreras
* Date: Fall of 2019
* Description: This program does the multiplicaiton of two matrixes. The program can do
* the multiplication using the "Divide and conquer" strategy either with 8 products (common
* divide and conquer) or 7 products (Strassen's algorithm).
* The matrixes are read from a .txt file, where each element in the same row of the matrix are
* divided by a space, and each new line is a row. The matrixes should be both square, and of the
* same size.
* The usage for this program is "java MatrixMultiplication [order] [matrixA.txt] [matrixB.txt] [numProducts]"
* where [order] is the size of the square matrixes, [matrixA.txt] and [matrixB.txt] are the 
* files where the matrixes are defined, and [numProducts] is 8 for the common divide and conquer stategy, 
* and 7 for Strassen's algorithm.
*/

import java.io.File;
import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class MatrixMultiplication{



	private static final int COMMON = 8, STRASSEN = 7, UP_RIGHT = 1, UP_LEFT = 2, DOWN_RIGHT = 3, DOWN_LEFT = 4;


	//Main
	public static void main(String args[]){
		if(args.length < 4){
			System.out.println("Ussage: java MatrixMultiplication [order] [matrixA.txt] [matrixB.txt] [numProducts]");
			System.exit(1);
		}

		int order = Integer.parseInt(args[0].trim());
		File source1 = new File(args[1].trim());
		File source2 = new File(args[2].trim());
		int method = Integer.parseInt(args[3].trim());

		if(!source1.exists() || !source2.exists()){
			System.out.println("Error: Couldn't find source files");
			System.exit(1);
		}

		//Read the files and convert them to matrixes of type double
		double matrix1[][] = fileToDoubleArray(order, source1);
		double matrix2[][] = fileToDoubleArray(order, source2);

		//Multiply
		double result[][];
		if(method == COMMON)
			result = commonMultiplication(order, matrix1, matrix2);
		else
			result = strassenMultiplication(order, matrix1, matrix2);

		System.out.println(doubleArrayToString(order, result));
	}



	public static double[][] commonMultiplication(int order, double matrix1[][], double matrix2[][]){

		if(order == 2)
			return simpleMultiplication(matrix1, matrix2);

		int halfOrder = order/2;
		double newMatrix[][] = new double[order][order];

		//Separates each matrix into quadrants of half the size of the matrix.
		//m1 is for the first matrix and m2 for the second.
		//u is for 'up' or the superior half, while d is for 'down' or the inferior half.
		//l is for 'left' or the left hald, and r is for 'right' or the right half.
		double m1ul[][] = divideMatrix(order, matrix1, UP_LEFT);
		double m1ur[][] = divideMatrix(order, matrix1, UP_RIGHT);
		double m1dl[][] = divideMatrix(order, matrix1, DOWN_LEFT);
		double m1dr[][] = divideMatrix(order, matrix1, DOWN_RIGHT);
		double m2ul[][] = divideMatrix(order, matrix2, UP_LEFT);
		double m2ur[][] = divideMatrix(order, matrix2, UP_RIGHT);
		double m2dl[][] = divideMatrix(order, matrix2, DOWN_LEFT);
		double m2dr[][] = divideMatrix(order, matrix2, DOWN_RIGHT);

		//Calculate the multiplication for each quadrant
		double[][] resultul = addition(halfOrder, commonMultiplication(halfOrder, m1ul, m2ul), commonMultiplication(halfOrder, m1ur, m2dl));
		double[][] resultur = addition(halfOrder, commonMultiplication(halfOrder, m1ul, m2ur), commonMultiplication(halfOrder, m1ur, m2dr));
		double[][] resultdl = addition(halfOrder, commonMultiplication(halfOrder, m1dl, m2ul), commonMultiplication(halfOrder, m1dr, m2dl));
		double[][] resultdr = addition(halfOrder, commonMultiplication(halfOrder, m1dl, m2ur), commonMultiplication(halfOrder, m1dr, m2dr));

		//Fill in the result matrix with each quadrant
		newMatrix = fillCuadrant(order, newMatrix, resultul, UP_LEFT);
		newMatrix = fillCuadrant(order, newMatrix, resultur, UP_RIGHT);
		newMatrix = fillCuadrant(order, newMatrix, resultdl, DOWN_LEFT);
		newMatrix = fillCuadrant(order, newMatrix, resultdr, DOWN_RIGHT);

		return newMatrix;
	}



	//Does the matrix multiplication using Strassen's algorithm.
	public static double[][] strassenMultiplication(int order, double matrix1[][], double matrix2[][]){

		if(order == 2)
			return simpleMultiplication(matrix1, matrix2);

		int halfOrder = order/2;
		double newMatrix[][] = new double[order][order];

		//Divide the matrixes in quadrants according to Strassen's algorithm
		double a[][] = divideMatrix(order, matrix1, UP_LEFT);
		double b[][] = divideMatrix(order, matrix1, UP_RIGHT);
		double c[][] = divideMatrix(order, matrix1, DOWN_LEFT);
		double d[][] = divideMatrix(order, matrix1, DOWN_RIGHT);
		double e[][] = divideMatrix(order, matrix2, UP_LEFT);
		double f[][] = divideMatrix(order, matrix2, UP_RIGHT);
		double g[][] = divideMatrix(order, matrix2, DOWN_LEFT);
		double h[][] = divideMatrix(order, matrix2, DOWN_RIGHT);

		//Calculates the seven products for the Strassen's algorithm.
		double p1[][] = strassenMultiplication(halfOrder, a, sustraction(halfOrder, f, h));
		double p2[][] = strassenMultiplication(halfOrder, addition(halfOrder, a, b), h);
		double p3[][] = strassenMultiplication(halfOrder, addition(halfOrder, c, d), e);
		double p4[][] = strassenMultiplication(halfOrder, d, sustraction(halfOrder, g, e));
		double p5[][] = strassenMultiplication(halfOrder, addition(halfOrder, a, d), addition(halfOrder, e, h));
		double p6[][] = strassenMultiplication(halfOrder, sustraction(halfOrder, b, d), addition(halfOrder, g, h));
		double p7[][] = strassenMultiplication(halfOrder, sustraction(halfOrder, a, c), addition(halfOrder, e, f));

		//Calculates the multiplication using the seven products.
		double[][] resultul = addition(halfOrder, addition(halfOrder, p5, p4), sustraction(halfOrder, p6, p2));
		double[][] resultur = addition(halfOrder, p1, p2);
		double[][] resultdl = addition(halfOrder, p3, p4);
		double[][] resultdr = addition(halfOrder, sustraction(halfOrder, p1, p3), sustraction(halfOrder, p5, p7));

		//Fills in the result matrix with the quadrants obtained
		newMatrix = fillCuadrant(order, newMatrix, resultul, UP_LEFT);
		newMatrix = fillCuadrant(order, newMatrix, resultur, UP_RIGHT);
		newMatrix = fillCuadrant(order, newMatrix, resultdl, DOWN_LEFT);
		newMatrix = fillCuadrant(order, newMatrix, resultdr, DOWN_RIGHT);

		return newMatrix;
	}


	//Returns the element by element addition of two matrixes of size order x order
	public static double[][] addition(int order, double matrix1[][], double matrix2[][]){
		double newMatrix[][] = new double[order][order];

		for(int i = 0; i < order; i++)
			for(int j = 0; j < order; j++)
				newMatrix[i][j] = matrix1[i][j] + matrix2[i][j];

		return newMatrix;
	}



	//Returns the element by element substraction of two matrixes of size order x order
	public static double[][] sustraction(int order, double matrix1[][], double matrix2[][]){
		double newMatrix[][] = new double[order][order];

		for(int i = 0; i < order; i++)
			for(int j = 0; j < order; j++)
				newMatrix[i][j] = matrix1[i][j] - matrix2[i][j];

		return newMatrix;
	}



	//Returns the matrix multiplication of two matrixes of size 2 x 2
	public static double[][] simpleMultiplication(double matrix1[][], double matrix2[][]){
		double newMatrix[][] = new double[2][2];

		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 2; j++)
			{
				newMatrix[i][j] = 0; 
				for(int k = 0; k < 2; k++)
					newMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
			}

		return newMatrix;
	}



	//Copies one quadrant of one matrix to another.
	public static double[][] fillCuadrant(int order, double filledMatrix[][], double fillerMatrix[][], int cuadrant){
		int offsetx, offsety, halfOrder = order/2;

		if(cuadrant == UP_RIGHT || cuadrant == UP_LEFT)
			offsety = 0;
		else
			offsety = halfOrder;

		if(cuadrant == UP_LEFT || cuadrant == DOWN_LEFT)
			offsetx = 0;
		else
			offsetx = halfOrder;

		for(int i = 0; i < halfOrder; i++)
			for(int j = 0; j < halfOrder; j++)
				filledMatrix[i + offsety][j + offsetx] = fillerMatrix[i][j];

		return filledMatrix;
	}



	//Returns just one quadrant of a matrix.
	public static double[][] divideMatrix(int order, double matrix[][], int cuadrant){
		int offsetx, offsety, newOrder = order/2;
		double newMatrix[][] = new double[newOrder][newOrder];

		if(cuadrant == UP_RIGHT || cuadrant == UP_LEFT)
			offsety = 0;
		else
			offsety = newOrder;

		if(cuadrant == UP_LEFT || cuadrant == DOWN_LEFT)
			offsetx = 0;
		else
			offsetx = newOrder;

		for(int i = 0; i < newOrder; i++)
			for(int j = 0; j < newOrder; j++)
				newMatrix[i][j] = matrix[i + offsety][j + offsetx];

		return newMatrix;
	}



	//Reads a .txt file with a defined matrix and converts it to a matrix of type double.
	//To define the matrix, the file must contain the matrix with the next format:
	//Each row is defined in a different line.
	//Each element of a row is separated by a space.
	private static double[][] fileToDoubleArray(int order, File source){
		double newMatrix[][] = new double[order][order];

		try{
			Scanner scanner = new Scanner(source).useLocale(Locale.US);;

			for(int i = 0; i < order; i++)
				for(int j = 0; j < order; j++)
					newMatrix[i][j] = scanner.nextDouble();

			scanner.close();
		}
		catch(Exception exception){
			System.out.println("Error: Couldn't read source files" + exception.toString());

			System.exit(2);
		}

		return newMatrix;
	}



	//Returns a string representation of a matrix.
	private static String doubleArrayToString(int order, double matrix[][]){
		StringBuilder newString = new StringBuilder();
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		DecimalFormat decimalFormat = new DecimalFormat("####.##", dfs);

		for(int i = 0; i < order; i++){
			for(int j = 0; j < order; j++){
				newString.append(decimalFormat.format(matrix[i][j]));
				newString.append('\t');
			}
			newString.append('\n');
		}

		return newString.toString();
	}
}