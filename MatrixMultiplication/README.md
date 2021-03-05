**Español más abajo**

# Gauss Multiplication
**Course:** Algorithms Analysis.<br>
**Date:** Fall of 2019.<br>
**Topics:** Algorithms analysis, Problem solving using algorithms, Divide and conquer, recursion.<br>
**Technologies used:** Java.<br>

#### Description:
This program is a console application that performs the multiplication of two square matrices of the same size, using the divide and conquer strategy. The program allows you to use two versions of the divide and conquer strategy, one with 8 products (common divide and conquer) and another with 7 products (Strassen algorithm). Here's how the algorithms work.

**8-product algorithm:**
* Let **A** and **B** be the two matrices to be multiplied, we divide them into upper left, upper right, lower left and lower right quadrants, with which we have the sub-matrices **Aul**, **Aur**, **All**, **Alr**, **Bul**, **Bur**, **Bll**, **Blr**.
* We calculate each of the quadrants of the result matrix **R**, where:<br>
**Rul = (Aul * Bul) + (Aur * Bll)**<br>
**Rur = (Aul * Bur) + (Aur * Blr)**<br>
**Rll = (All * Bul) + (Alr * Bll)**<br>
**Rlr = (All * Bur) + (Alr * Blr)**
* We construct the result matrix ** R ** from the calculated quadrants.
* We can observe that to make the previous calculation we need to calculate 8 products and each product is done by following the previous steps recursively for each pair of sub-matrices.

**7-prodcut algorithm:**
* Let **A** and **B** be the two matrices to be multiplied, we divide them into upper left, upper right, lower left and lower right quadrants, with which we have the sub-matrices **Aul**, **Aur**, **All**, **Alr**, **Bul**, **Bur**, **Bll**, **Blr**.
* We calculate 7 products that we will call **P1**, **P2**, **P3**, **P4**, **P5**, **P6** and **P7**, where :<br>
**P1 = Asi * (Bsd - Bid)**<br>
**P2 = (Asi + Asd) * Bid**<br>
**P3 = (Aii + Aid) * Bsi**<br>
**P4 = Aid * (Bii - Bsi)**<br>
**P5 = (Asi + Aid) * (Bsi + Bid)**<br>
**P6 = (Asd - Aid) * (Bii + Bid)**<br>
**P7 = (Asi - Aii) * (Bsi + Bsd)**
* Now the quadrants of the result matrix **R** are calculated using the previous products as follows:<br>
**Rsi = - P2 + P4 + P5 + P6**<br>
**Rsd = P1 + P2**<br>
**Rii = P3 + P4**<br>
**Rid = P1 - P3 + P5 - P7**
* We construct the result matrix **R** from the calculated quadrants.
* We can observe that to make the previous calculation we need to make 8 products and each one is done by following the previous steps recursively for each pair of sub-matrices.

Let **N** be the size of the edge of the square matrix, the asymptotic complexity of the 8-product algorithm is **O (N ^ 3)** and the asymptotic complexity of the 7-product algorithm is approximately **O (N ^ 2,807)**.

This program is primarily for educational purposes. 

#### Instructions
**Compilation:** The source code is in the folder "src". The source code was written with Java 11 in mind so compatibility with other versions of Java is not guaranteed. To compile using console use:

```
javac MatrixMultiplication.java
```

**Usage:** You can find the program compiled using Java 11 in the folder "cls". To run the program using the console use:

```
java MatrixMultiplication [order] [matrix1] [matrix2] [productsNum]
```

Where **[order]** is the size of the edge of the matrices **[matrix1]** and **[matrix2]** that are to be multiplied. **[productsNum]** is 7 or 8 depending on the algorithm you want to use.

After executing the program, it will print the result of the matrix multiplication on the console.



# Multiplicación de Gauss
**Materia:** Análisis de Algoritmos<br>
**Fecha:** Otoño de 2019.<br>
**Temas:** Análisis de algoritmos, Resolución de problemas utilizando algoritmos, Divide y vencerás, Recursividad.<br>
**Tecnologías utilizadas:** Java.<br>

#### Descripción:
Este programa es una aplicación de consola que realiza la multiplicación de dos matrices cuadradas y del mismo tamaño, utilizando la estrategia de divide y vencerás. El programa permite utilizar dos versiones de la estrategia divide y vencerás, una de 8 productos (divide y vencerás común) y otra de 7 productos (algoritmo de Strassen). A continuación se explica cómo funcionan los algoritmos.

**Algoritmo de 8 productos:**
* Sea **A** y **B** las dos matrices a multiplicar, las dividimos en cuadrantes superior izquierdo, superior derecho, inferior izquierdo e inferior derecho, con lo que tenemos las submatrices **Asi**, **Asd**, **Aii**, **Aid**, **Bsi**, **Bsd**, **Bii**, **Bid**.
* Se calcula cada uno de los cuadrantes de la matriz resultado **R**, donde:<br>
**Rsi = (Asi * Bsi) + (Asd * Bii)**<br>
**Rsd = (Asi * Bsd) + (Asd * Bid)**<br>
**Rii = (Aii * Bsi) + (Aid * Bii)**<br>
**Rid = (Aii * Bsd) + (Aid * Bid)**
* Construimos la matriz resultado **R** a partir de los cuadrantes calculados.
* Cómo podemos observar, para hacer el cálculo anterior necesitamos realizar 8 productos y cada uno se hace siguiendo los pasos anteriores de forma recursiva par cada para de submatrices.

**Algoritmo de 7 productos:**
* Sea **A** y **B** las dos matrices a multiplicar, las dividimos en cuadrantes superior izquierdo, superior derecho, inferior izquierdo e inferior derecho, con lo que tenemos las submatrices **Asi**, **Asd**, **Aii**, **Aid**, **Bsi**, **Bsd**, **Bii**, **Bid**.
* Se calculan 7 productos que denominaremos **P1**, **P2**, **P3**, **P4**, **P5**, **P6** y **P7**, donde:<br>
**P1 = Asi * (Bsd - Bid)**<br>
**P2 = (Asi + Asd) * Bid**<br>
**P3 = (Aii + Aid) * Bsi**<br>
**P4 = Aid * (Bii - Bsi)**<br>
**P5 = (Asi + Aid) * (Bsi + Bid)**<br>
**P6 = (Asd - Aid) * (Bii + Bid)**<br>
**P7 = (Asi - Aii) * (Bsi + Bsd)**
* Ahora se calculan los cuadrantes de la matriz resultado **R** usando los productos anteriores de la siguiente manera:<br>
**Rsi = - P2 + P4 + P5 + P6**<br>
**Rsd = P1 + P2**<br>
**Rii = P3 + P4**<br>
**Rid = P1 - P3 + P5 - P7**
* Construimos la matriz resultado **R** a partir de los cuadrantes calculados.
* Cómo podemos observar, para hacer el cálculo anterior necesitamos realizar 8 productos y cada uno se hace siguiendo los pasos anteriores de forma recursiva para cada par de submatrices.

Sea **N** el tamaño del arista de la matriz cuadrada, la complejidad asintótica del algoritmo de 8 productos es de **O(N^3)** y la complejidad asintótica del algoritmo de 7 productos es de aproximadamente **O(N^2.807)**.

Este programa tiene principalmente fines didácticos.

#### Instrucciones:
**Compilación:** El código fuente se encuentra en la carpeta "src". El código fuente fue escrito tomando en cuenta la versión 11 de Java por lo que no se garantiza la compatibilidad con otras versiones de Java. Para compilar en consola hay que usar:

```
javac MatrixMultiplication.java
```

**Modo de uso:** Puedes encontrar el programa ya compilado con Java 11 en la carpeta "cls". Además, en la carpeta "exampleMatrixes" se encuentran matrices de prueba. Para ejecutar el programa hay que usar:

```
java MatrixMultiplication [orden] [matriz1] [matriz2] [numProductos]
```
Donde **[orden]** es el tamaño de la arista de las matrices a multiplicar **[matriz1]** y **[matriz2]**. **[numProductos]** es 7 u 8 dependiendo del algoritmo que queramos utilizar.

Al ejecutar el programa, este imprimirá el resultado de la multiplicación de las matrices en la consola.