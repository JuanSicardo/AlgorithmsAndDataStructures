**Español más abajo**

# Binary Multiplication
**Course:** Algorithms Analysis.<br>
**Date:** Fall of 2019.<br>
**Topics:** Algorithms analysis, Problem solving using algorithms, Divide and conquer, recursion.<br>
**Technologies used:** Java.<br>

#### Description:
This program is a console application that multiplies two binary numbers. The algorithm that performs the multiplication uses the divide and conquer strategy and recursion. The algorithm that performs the multiplication performs the following steps:
* Let **A** and **B** be the binary numbers to be multiplied, **Da** and **Db** will be the number of digits that **A** and **B** have respectively.
* We add enough leading zeros to **A** or **B** so that Da and Db are equal and they are both powers of 2. We will use **D** to refer to **Da** or **Db** since they are both equal.
* **A** and **B** are divided into halves, a leading half and a trailing half, with which we have **Al**, **At**, **Bl**, **Bt**.
* To do the multiplication we use the formula **R = (Al * Bl) (2 ^ n) + (At * ​​Bt)** where **n = D / 2**.
* To multiply **Al * Bl** and **At * Bt**, the previous two steps are carried out recursively, unless **D** for any of these quantities is 1 in which case a simple arithmetic multiplication will be carried out.

This program is primarily for educational purposes. 

#### Instructions
**Compilation:** The source code is in the folder "src". The source code was written with Java 11 in mind so compatibility with other versions of Java is not guaranteed. To compile using console use:

```
javac BinaryMultiplication.java
```

**Usage:** You can find the program compiled using Java 11 in the folder "cls". To run the program using the console use:

```
java BinaryMultiplication [binary1] [binary2]
```
Where **[binary1]** and **[binary2]** are the two binary numbers to be multiplied.

When executed, the program will print the result of the multiplication on console output.



# Multiplicación Binaria
**Materia:** Análisis de Algoritmos<br>
**Fecha:** Otoño de 2019.<br>
**Temas:** Análisis de algoritmos, Resolución de problemas utilizando algoritmos, Divide y vencerás, Recursividad.<br>
**Tecnologías utilizadas:** Java.<br>

#### Descripción:
Este programa es una aplicación de consola que multiplica dos números binarios. El algoritmo que realiza la multiplicación utiliza la estrategia divide y vencerás y la recursividad. El algoritmo que realiza la multiplicación realiza los siguientes pasos:
* Sea **A** y **B** los números binarios a multiplicar, **Da** y **Db** serán la cantidad de dígitos que tienen **A** y **B** respectivamente.
* Se le agregan los suficientes ceros a la izquierda a **A** y a **B** de tal manera que **Da** y **Db** sean iguales y que sean potencias de 2. Utilizaremos a **D** para referirnos a **Da** o a **Db** ya que ambos son iguales.
* Se dividen **A** y **B** en mitades, una izquierda y una derecha, con lo que tenemos a **Ai**, **Ad**, **Bi**, **Bd**.
* Para hacer la multiplicación se utiliza la fórmula **R = (Ai * Bi)(2^n) + (Ad * Bd)** donde **n = D / 2**.
* Para multiplicar **Ai * Bi** y **Ad * Bd** se realizan los dos pasos anteriores de forma recursiva, a menos que **D** para alguna de estas cantidades sea 1 en cuyo caso se realizará una multiplicación aritmética simple.

Este programa principalmente tiene propósitos didácticos.

#### Instrucciones:
**Compilación:** El código fuente se encuentra en la carpeta "src". El código fuente fue escrito tomando en cuenta la versión 11 de Java por lo que no se garantiza la compatibilidad con otras versiones de Java. Para compilar en consola hay que usar:

```
javac BinaryMultiplication.java
```

**Modo de uso:** Puedes encontrar el programa ya compilado con Java 11 en la carpeta "cls". Para ejecutar el programa hay que usar:

```
java BinaryMultiplication [binario1] [binario2]
```
Donde **[binaio1]** y **[binario2]** son los dos números binarios que se van a multiplicar.

Al ser ejecutado, el programa imprimirá el resultado de la multiplicación en la consola.