**Español más abajo**

# Matrix Multiplication (Simple)
**Course:** Algorithms Analysis.<br>
**Date:** Fall of 2019.<br>
**Topics:** Algorithms analysis, Problem solving using algorithms.<br>
**Technologies used:** C, Makefile.<br>

#### Description:
This program performs the multiplication of two matrices. The program assumes that the matrices that the user enters can be multiplied with each other. The algorithm used is a simple non-parallelized iterative algorithm.
Let **A** be a matrix with **N** rows and **M** columns, and **B** a matrix with **M** rows and **L** columns, the asymptotic complexity of the algorithm used is given by **O(N * M * L)**.

#### Instructions
**Compilation:** The source code is in the "src" folder along with a makefile. To compile in console you have to use:

```
make matrixmultiplication
```

or just simply

```
make
```

**Usage:** After compiling the program, it can be executed on Windows with:

```
matrixmultiplication
```

or in Linux with:

```
./matrixmultiplication.exe
```

When executing the program, the user has to enter the number of rows and columns that the first matrix has, and the number of columns of the second matrix, all these values ​​are integers. Then the user will be asked to enter each of the elements of the matrix in the order indicated. The elements of the arrays can be numbers in floating point format.

Once this is done, the program will print the matrices to be multiplied in order for the user to verify that the information was entered correctly, and then the result matrix is ​​printed on the console.

# Multiplicación de Matrices (Simple)
**Materia:** Análisis de Algoritmos<br>
**Fecha:** Otoño de 2019.<br>
**Temas:** Análisis de algoritmos, Resolución de problemas utilizando algoritmos.<br>
**Tecnologías utilizadas:** C, Makefile.<br>

#### Descripción:
Este programa realiza la multiplicación de dos matrices. El programa asume que las matrices que el usuario ingrese se pueden multiplicar entre sí. El algoritmo que se utiliza es un algoritmo simple iterativo sin paralelismo.
Sea **A** una matriz con **N** filas y **M** columnas, y **B** una matriz con **M** filas y **L** columnas, la complejidad asintótica del algoritmo utilizado está dada por **O(N * M * L)**.

#### Instrucciones:
**Compilación:** El código fuente se encuentra en la carpeta "src" junto con un makefile. Para compilar en consola hay que usar:

```
make matrixmultiplication
```

o simplemente

```
make
```

**Modo de uso:** Tras compilar el programa, se puede ejecutar en Windows con:

```
matrixmultiplication
```

y en Linux con:

```
./matrixmultiplication.exe
```

**Modo de uso:** Al ejecutar el programa el usuario tiene que ingresar el número de filas y columnas que tiene la primera matriz, y el número de columnas de la segunda matriz, todos estos valores son números enteros. Después se le pedirá al usuario ingrese cada uno de los elementos de la matriz en el orden que se le indica. Los elementos de las matrices pueden ser números en formato de punto flotante.

Una vez hecho lo anterior, el programa imprimirá las matrices que se van a multiplicar con el propósito de que el usuario verifique que ingresó bien la información, y después se imprime en consola la matriz resultado.