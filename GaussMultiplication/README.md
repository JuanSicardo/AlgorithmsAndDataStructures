**Español más abajo**

# Gauss Multiplication
**Course:** Algorithms Analysis.<br>
**Date:** Fall of 2019.<br>
**Topics:** Algorithms analysis, Problem solving using algorithms, Divide and conquer, recursion.<br>
**Technologies used:** Java.<br>

#### Description:
This program is a console application that multiplies two numbers of base n where 2 <= n <= 16. To carry out the multiplication, the programm uses the Gauss multiplication formula, in which the divide and conquer strategy and recursion are employed to calculate the result of the multiplication. The algorithm that performs the multiplication performs the following steps:
* Let **A** and **B** be the binary numbers to be multiplied, **Da** and **Db** will be the number of digits that **A** and **B** have respectively.
* We add enough leading zeros to **A** or **B** so that Da and Db are equal and they are both powers of the base **n**. We will use **D** to refer to **Da** or **Db** since they are both equal.
* **A** and **B** are divided into halves, a leading half and a trailing half, with which we have **Al**, **At**, **Bl**, **Bt**.
* To do the multiplication we use the formula **R = (Al * Bl) (n ^ x) + (At * ​​Bt)** where **x = D / 2**.
* To multiply **Al * Bl** and **At * Bt**, the previous two steps are carried out recursively, unless **D** for any of these quantities is 1 in which case a simple arithmetic multiplication will be carried out.

This program is primarily for educational purposes. 

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
Este programa es una aplicación de consola que multiplica dos números de base **n** donde **2 <= n <= 16**. Para realizar la multiplicación se utiliza la fórmula de multiplicación de Gauss, en el cuál se aplica la estategia de divide y vencerás, así como la recursión para encontrar el resultado de la multiplicación. El algoritmo que realiza la multiplicación realiza los siguientes pasos:
* Sea **A** y **B** los números a multiplicar, **Da** y **Db** serán la cantidad de dígitos que tienen **A** y **B** respectivamente.
* Se le agregan los suficientes ceros a la izquierda a **A** y a **B** de tal manera que **Da** y **Db** sean iguales y que sean potencias de la base **n**. Utilizaremos a **D** para referirnos a **Da** o a **Db** ya que ambos son iguales.
* Se dividen **A** y **B** en mitades, una izquierda y una derecha, con lo que tenemos a **Ai**, **Ad**, **Bi**, **Bd**.
* Para hacer la multiplicación se utiliza la fórmula **R = (Ai * Bi)(n^x) + (Ad * Bd)** donde **x = D / 2**.
* Para multiplicar **Ai * Bi** y **Ad * Bd** se realizan los dos pasos anteriores de forma recursiva, a menos que **D** para alguna de estas cantidades sea 1 en cuyo caso se realizará una multiplicación aritmética simple.

Este programa principalmente tiene propósitos didácticos.

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