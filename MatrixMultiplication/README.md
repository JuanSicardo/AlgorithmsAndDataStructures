**Español más abajo**

# Gauss Multiplication
**Course:** Algorithms Analysis.<br>
**Date:** Fall of 2019.<br>
**Topics:** Algorithms analysis, Problem solving using algorithms, Divide and conquer, recursion.<br>
**Technologies used:** Java.<br>

#### Description:
This program is a console application that multiplies two numbers of base n where 2 <= n <= 16. To carry out the multiplication, the programm uses the Gauss multiplication formula, in which the divide and conquer strategy and recursion are employed to calculate the result of the multiplication. This program is primarily for educational purposes. 

#### Instructions
**Compilation:** The source code is in the folder "src". The source code was written with Java 11 in mind so compatibility with other versions of Java is not guaranteed. To compile using console use:

```
javac GaussMultiplication.java
```

**Usage:** You can find the program compiled using Java 11 in the folder "cls". To run the program using the console use:

```
java GaussMultiplication [base] [number1] [number2]
```
Where **[base]** is the numerical base in which the numbers to be multiplied are, for example, 2 to work with binary numbers, 8 for octal numbers, 10 for decimals or 16 for hexadecimal numbers. Remember that bases must be expressed using whole numbers between 2 and 16 inclusive. **[number1]** and **[number2]** are the two numbers to multiply, for bases greater than 10, the capital letter convention will be used to represent digits greater than 9.

When you run the program, it will print the result of the multiplication on the console.



# Multiplicación de Gauss
**Materia:** Análisis de Algoritmos<br>
**Fecha:** Otoño de 2019.<br>
**Temas:** Análisis de algoritmos, Resolución de problemas utilizando algoritmos, Divide y vencerás, Recursividad.<br>
**Tecnologías utilizadas:** Java.<br>

#### Descripción:
Este programa es una aplicación de consola que multiplica realiza la multiplicación de dos matrices cuadradas y del mismo tamaño, utilizando la estrategia de divide y vencerás. El programa permite utilizar dos versiones de la estrategia de divide y vencerás, una de 8 productos (divide y vencerás común) y otra de 7 productos (algoritmo de Strassen). A continuación se explica cómo funcionan los algoritmos.

**Algoritmo de 8 productos:**
* Sea **A** y **B** las dos matrices a multiplicar, las dividimos en cuadrantes superior izquierdo, superior derecho, inferior izquierdo e inferior derecho, con lo que tenemos las sumbatrices **Asi**, **Asd**, **Aii**, **Aid**, **Bsi**, **Bsd**, **Bii**, **Bid**.
* Se calcula cada uno de los cuadrantes de la matriz resultado **R**, donde:<br>
**Rsi = (Asi * Bsi) + (Asd * Bii)**<br>
**Rsd = (Asi * Bsd) + (Asd * Bid)**<br>
**Rii = (Aii * Bsi) + (Aid * Bii)**<br>
**Rid = (Aii * Bsd) + (Aid * Bid)**
* Construimos la matriz resultado **R** a partir de los cuadrantes calculados.
* Cómo podemos observar, para hacer el cálcuo anterior necesitamos realizar 8 productos y cada uno se hace siguiendo los pasos anteriores de forma recursiva par cada para de submatrices.

**Algoritmo de 7 productos:**
* Sea **A** y **B** las dos matrices a multiplicar, las dividimos en cuadrantes superior izquierdo, superior derecho, inferior izquierdo e inferior derecho, con lo que tenemos las sumbatrices **Asi**, **Asd**, **Aii**, **Aid**, **Bsi**, **Bsd**, **Bii**, **Bid**.
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
* Cómo podemos observar, para hacer el cálcuo anterior necesitamos realizar 8 productos y cada uno se hace siguiendo los pasos anteriores de forma recursiva para cada par de submatrices.

Sea **N** el tamaño del arista de la matriz cuadrada, la complejidad asintótica del algoritmo de 8 productos es de **O(N^3)** y la complejidad asintótica del algoritmo de 7 productos es de aproximadament **O(N^2.807)**.

#### Instrucciones:
**Compilación:** El código fuente se encuentra en la carpeta "src". El código fuente fue escrito tomando en cuenta la versión 11 de Java por lo que no se garantiza la compatibilidad con otras versiones de Java. Para compilar en consola hay que usar:

```
javac GaussMultiplication.java
```

**Modo de uso:** Puedes encontrar el programa ya compilado con Java 11 en la carpeta "cls". Para ejecutar el programa hay que usar:

```
java GaussMultiplication [base] [numero1] [numero2]
```
Donde **[base]** es la base numérica en la que se encuentran los números a multiplicar, por ejemplo, un 2 para trabajar con números binarios, 8 para números octales, 10 para decimales o 16 para números hexadecimales. Recuerda que las bases deberán ser expresadas utilizando números enteros entre el 2 y el 16 inclusivo. **[numero1]** y **[numero2]** son los dos números a multiplicar, para bases superiores a 10, se utilizará la convención de letras mayúsculas para representar a los dígitos superiores a 9.

Al ejecutar el programa, este imprimirá el resultado de la multiplicación en la consola.