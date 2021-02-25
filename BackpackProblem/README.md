**Español más abajo**

# The Backpack Problem
**Course:** Algorithms Analysis.<br>
**Date:** Fall of 2019.<br>
**Topics:** Algorithms analysis, Problem solving using algorithms, Dynamic programming.<br>
**Technologies used:** Java.<br>

#### Description:
This program solves a problem proposed by the teacher called "The Backpack Problem" using dynamic programming strategies. The backpack problem goes like this:<br>
"A burglar breaks into a jewelry store. To carry the stolen objects, he brought a backpack into the store  which has a certain weight capacity, if the capacity of the backpack is surpassed, it may break and all the stolen objects would be lost. Each object in the jewelry store has an associated weight and a profit that the burglar can make if the object is sold in the black market. Inside the store, the burglar weights every object and calculates how profitable each item will be. Now, the burglar wants to know which items he can steal that won't surpass the capacity of his backpack while making the most profit".

#### Instructions
**Compilation:** The source code is in the folder "src". The source code was written with Java 11 in mind so compatibility with other versions of Java is not guaranteed. To compile using console use:

```
javac Backpack.java
```

**Usage:** You can find the program compiled using Java 11 in the folder "cls". To run the program using the console use:

```
java Backpack
```

Then you are prompted to enter the backpack weight capacity in floating point number format and the number of objects inside the jewelry store. For each object you need to define its name, profit and weight.

The program will display lists of object the burglar can steal that will make him the most profit. As a byproduct of the algorithm, the program may display the same list of objects more than once. Also, there may be more than one combination of items that will make the most profit and still fit in the backpack.


# El problema de la mochila
**Materia:** Análisis de Algoritmos<br>
**Fecha:** Otoño de 2019.<br>
**Temas:** Análisis de algoritmos, Resolución de problemas utilizando algoritmos, Programación dinámica.<br>
**Tecnologías utilizadas:** Java.<br>

#### Descripción:
Este programa resuelve in programa propuesto por el profesor llamado "El Problema de la Mochila" utilizando la programación dinámica. El problema de la mochila dice así:<br>
"Un ladrón logra entrar en una joyería. Para cargar los objetos que se va a robar, el ladrón carga una mochila que tiene una cierta capacidad de carga en peso, si se sobrepasa esa capacidad de carga, la mochila se romperá y se perderán los objetos robados. Cada objeto en la joyería tiene un peso asociado y una ganancia que el ladrón puede obtener si vende ese objeto en el mercado negro. Una ven dentro de la joyería, el ladrón pesa cada objeto y calcula la ganancia que puede obtener de él. Ahora, el ladrón quiere saber que objetos puede robar sin sobrepasar la capacidad de carga de su mochila y que le permita obtener la mayor ganancia posible."

#### Instrucciones:
**Compilación:** El código fuente se encuentra en la carpeta "src". El código fuente fue escrito tomando en cuenta la versión 11 de Java por lo que no se garantiza la compatibilidad con otras versiones de Java. Para compilar en consola hay que usar:

```
javac Backpack.java
```

**Modo de uso:** Puedes encontrar el programa ya compilado con Java 11 en la carpeta "cls". Para ejecutar el programa hay que usar:

```
java Backpack
```

El programa te pedirá ingresar la capacidad de carga en peso de la mochila utilizando números de punto flotante y la cantidad de objetos que hay en la joyería. Por cada objeto, el programa te pedirá definir su nombre, ganancia y peso.

El programa mostrará varias listas de objetos que él ladrón puede robar para tener la mayor ganancia. Derivado del algoritmo, es posible que se imprima la misma lista más de una vez. También es posible que haya más de una combinación de objetos que le permitan al ladrón obtener la mayor ganancia y no exceder la capacidad máxima de la mochila.