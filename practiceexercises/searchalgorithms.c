/* Author: Juan Antonio Sicardo Contreras
 * Date: Fall 2019
 * Description: This program implements sequential search and binary search and binary tree search algorithms. For each
 * algorithm we have different tests where the searched element may be at the start, in the middle, at the end or not be
 * in the array or tree. The program counts how many operations each algorithm makes before finding the element to then
 * compare the efficiency of each algorithm.
 */

#define TAMANIO_ARREGLO_SECUENCIAL 20
#define TAMANIO_ARREGLO_BINARIO 20

#include <stdio.h>
#include <stdlib.h>

typedef struct node {
    int data;
    struct node* izquierda;
    struct node* derecha;
} node;


int busquedaSecuencial();
int busquedaBinaria();
int arbolDeBusqueda();
node* create_node();



int busquedaSecuencial(int *arreglo, int length, int n)
{
	int contadorDePasos = 1; //comienza en uno por la declaración de i.
	int i;

	contadorDePasos++; //Se aumenta uno por la inicialización de i.
	for(i = 0; i < length; i++)
	{
		contadorDePasos++; //Se aumenta 1 por la comparación hecha
		contadorDePasos += 2; //Se aumentan 2 por el acceso a memoria y comparación
		if(arreglo[i] == n)
		{
			printf("-Se encontró el valor %d en el lugar %d del arreglo\n", n, i+1);
			contadorDePasos += 2; //Se aumentan 1 por la impresión  y el retorno
			return contadorDePasos;
		}
		contadorDePasos += 2; //se aumentan 2 por el incremento que se hace en i
	}
	contadorDePasos++; //Se aumenta 1 por la última ejecución de la comparación antes de que salga del for

	printf("-No se encontró el valor %d en el arreglo\n", n);
	contadorDePasos += 2; //Se aumentan 2 por la impresión y el retorno
	return contadorDePasos;
}



int busquedaBinaria(int *arreglo, int length, int n)
{
	int contadorDePasos = 0;

	int inicio = 0, final = length;
	contadorDePasos = contadorDePasos + 4;	//Se aumenta 4 por las declaraciones y las asignaciones.

	int medio = (inicio+final)/2;
	contadorDePasos = contadorDePasos + 4;	//Se aumenta 4 por la declaración, la asignación y las operaciones


	while(inicio <= final)
	{
		contadorDePasos = contadorDePasos + 1; //Se aumenta 1 por la comparación para el while

		contadorDePasos = contadorDePasos + 2;	//Se aumentan 2 por la comparación y el acceso de memoria en el if
		if(arreglo[medio] < n)
		{
			contadorDePasos = contadorDePasos + 2;	//Se aumentan dos por la operación y la asignación
			inicio = medio + 1;
		}
		else
		{
			contadorDePasos = contadorDePasos + 2;	//Se aumentan 2 por la comparación y el acceso de memoria en el if
			if(arreglo[medio] == n)
			{
				contadorDePasos = contadorDePasos + 2;	//Se aumentan 2 por la impresión y el retorno
				printf("-Se encontró el valor %d en el lugar %d del arreglo\n", n, medio + 1);
				return contadorDePasos;
			}
			else
			{
				contadorDePasos = contadorDePasos + 2; //Se aumentan 2 por la asignacion y la operación
				final = medio - 1;
			}
		}

		contadorDePasos = contadorDePasos + 3;	//Se aumentan tres por la asignación y las operaciones
		medio = (inicio+final)/2;
	}
	contadorDePasos = contadorDePasos + 1; //Se aumenta 1 por la última comparación del while cuando se sale

	contadorDePasos = contadorDePasos + 2;	//Se aumentan 2 por la impresión y el retorno
	printf("-No se encontró el valor %d en el arreglo\n", n);
	return contadorDePasos;
}



node* create_node(int data)
{
    node *new_node = (node*)malloc(sizeof(node));
    if(new_node == NULL)
    {
        fprintf (stderr, "Out of memory!!! (create_node)\n");
        exit(1);
    }
    new_node->data = data;
    new_node->izquierda = NULL;
    new_node->derecha = NULL;
    return new_node;
}



void addNodoCargado(node *raiz, int valor)
{
	if(raiz->izquierda == NULL)
	{
		raiz->izquierda = create_node(valor);
		return;
	}
	else
		addNodoCargado(raiz->izquierda, valor);
}



node* crearArbolBalanceado()
{
	node *n0,*n3,*n6,*n9,*n12,*n15,*n18,*n21,*n24,*n27,*n30,*n33,*n36,*n39,*n42,*n45,*n48,*n51,*n54,*n57;

	n0 = create_node(0);
	n3 = create_node(3);
	n6 = create_node(6);
	n9 = create_node(9);
	n12 = create_node(12);
	n15 = create_node(15);
	n18 = create_node(18);
	n21 = create_node(21);
	n24 = create_node(24);
	n27 = create_node(27);
	n30 = create_node(30);
	n33 = create_node(33);
	n36 = create_node(36);
	n39 = create_node(39);
	n42 = create_node(42);
	n45 = create_node(45);
	n48 = create_node(48);
	n51 = create_node(51);
	n54 = create_node(54);
	n57 = create_node(57);

	n27->izquierda = n12;
	n27->derecha = n42;
	n12->izquierda = n3;
	n12->derecha = n18;
	n42->izquierda = n33;
	n42->derecha = n51;
	n3->izquierda = n0;
	n3->derecha = n6;
	n18->izquierda = n15;
	n18->derecha = n21;
	n33->izquierda = n30;
	n33->derecha = n36;
	n51->izquierda = n45;
	n51->derecha = n54;
	n6->derecha = n9;
	n21->derecha = n24;
	n36->derecha = n39;
	n45->derecha = n48;
	n54->derecha = n57;

	return n27;
}



void display_tree(node* nd)
{
    if (nd == NULL)
        return;
    /* display node data */
    printf("%d",nd->data);
    if(nd->izquierda != NULL)
        printf("(I:%d)",nd->izquierda->data);
    if(nd->derecha != NULL)
        printf("(D:%d)",nd->derecha->data);
    printf("\n");

    display_tree(nd->izquierda);
    display_tree(nd->derecha);
}



int arbolDeBusqueda(node *actual, int n, int* ptrPasos)
{
	*ptrPasos = *ptrPasos + 1;	//por la comparación
	if(actual == NULL)
	{
		*ptrPasos = *ptrPasos + 1;	//por el retorno
		return 0;
	}

	*ptrPasos = *ptrPasos + 2; //por la comparación y el acceso a memoria
	if(actual->data == n)
	{
		*ptrPasos = *ptrPasos + 1;	//por el retorno
		return 1;
	}

	*ptrPasos = *ptrPasos + 2;	//por la comparación y el acceso a memoria
	if(n < actual->data)
	{
		*ptrPasos = *ptrPasos + 1;	//por la comparacion
		if(arbolDeBusqueda(actual->izquierda, n, ptrPasos) == 1)
		{
			*ptrPasos = *ptrPasos + 2; //por la impresión y el retorno
			printf("izq <- ");
			return 1;
		}
		else
		{
			*ptrPasos = *ptrPasos + 1; //por el retorno
			return 0;
		}
	}
	else
	{
		*ptrPasos = *ptrPasos + 1;	//por la comparacion
		if(arbolDeBusqueda(actual->derecha, n, ptrPasos) == 1)
		{
			*ptrPasos = *ptrPasos + 2; //por la impresión y el retorno
			printf("der <- ");
			return 1;
		}
		else
		{
			*ptrPasos = *ptrPasos + 1;	//por el retorno
			return 0;
		}
	}
}



int main()
{
	int *arregloSecuencial, *arregloBinario, *ptrPasos, i, n, pasos;
	node *arbolCargadoIzquierda, *arbolBalanceado;

	arregloSecuencial = (int*) malloc(TAMANIO_ARREGLO_SECUENCIAL * sizeof(int));
	arregloBinario = (int*) malloc(TAMANIO_ARREGLO_BINARIO * sizeof(int));
	ptrPasos = (int*) malloc(sizeof(int));

	for(i = 0; i < TAMANIO_ARREGLO_SECUENCIAL; i++)
		arregloSecuencial[i] = i * 3;

	for(i = 0; i < TAMANIO_ARREGLO_BINARIO; i++)
		arregloBinario[i] = i * 3;

	arbolCargadoIzquierda = create_node(57);

	for(i = 1; i < 20; i++)
		addNodoCargado(arbolCargadoIzquierda, 57 - (i*3));

	arbolBalanceado = crearArbolBalanceado();

	printf("*****Práctica 2: Algoritmos de Busqueda*****\n\n\n");

	printf("**Busqueda Secuencial**\n\nArreglo: ");
	for(i = 0; i < TAMANIO_ARREGLO_SECUENCIAL; i++)
		printf("[%d] ", arregloSecuencial[i]);

	n = 0;
	printf("\n\nPrueba 1: El valor está al inicio, el valor buscado es %d\n", n);
	pasos = busquedaSecuencial(arregloSecuencial, TAMANIO_ARREGLO_SECUENCIAL, n);
	printf("-Se ejecutaron %d pasos\n\n", pasos);

	n = 30;
	printf("Prueba 2: El valor está en medio, el valor buscado es %d\n", n);
	pasos = busquedaSecuencial(arregloSecuencial, TAMANIO_ARREGLO_SECUENCIAL, n);
	printf("-Se ejecutaron %d pasos\n\n", pasos);

	n = 57;
	printf("Prueba 3: El valor está al final, el valor buscado es %d\n", n);
	pasos = busquedaSecuencial(arregloSecuencial, TAMANIO_ARREGLO_SECUENCIAL, n);
	printf("-Se ejecutaron %d pasos\n\n", pasos);

	n = 2;
	printf("Prueba 4: El valor no se encuentra, el valor buscado es %d\n", n);
	pasos = busquedaSecuencial(arregloSecuencial, TAMANIO_ARREGLO_SECUENCIAL, n);
	printf("-Se ejecutaron %d pasos\n\n\n", pasos);

	printf("**Busqueda Binaria**\n\nArreglo: ");
	for(i = 0; i < TAMANIO_ARREGLO_BINARIO; i++)
		printf("[%d] ", arregloBinario[i]);

	n = 0;
	printf("\n\nPrueba 1: El valor está al inicio, el valor buscado es %d\n", n);
	pasos = busquedaBinaria(arregloBinario, TAMANIO_ARREGLO_BINARIO, n);
	printf("-Se ejecutaron %d pasos\n\n", pasos);

	n = 30;
	printf("Prueba 2: El valor está en medio, el valor buscado es %d\n", n);
	pasos = busquedaBinaria(arregloBinario, TAMANIO_ARREGLO_BINARIO, n);
	printf("-Se ejecutaron %d pasos\n\n", pasos);

	n = 57;
	printf("Prueba 3: El valor está al final, el valor buscado es %d\n", n);
	pasos = busquedaBinaria(arregloBinario, TAMANIO_ARREGLO_BINARIO, n);
	printf("-Se ejecutaron %d pasos\n\n", pasos);

	n = 2;
	printf("Prueba 4: El valor no se encuentra, el valor buscado es %d\n", n);
	pasos = busquedaBinaria(arregloBinario, TAMANIO_ARREGLO_BINARIO, n);
	printf("-Se ejecutaron %d pasos\n\n\n", pasos);

	printf("**Arbol de Busqueda Binaria Cargado a la Izquierda**\n\nEstructura del arbol:\n");
	display_tree(arbolCargadoIzquierda);

	n = 0;
	*ptrPasos = 0;
	printf("\nPrueba 1: El arbol está cargdo a la izquierda y el valor se encuentra hasta el final, el valor buscado es: %d\n", n);
	pasos = arbolDeBusqueda(arbolCargadoIzquierda, n, ptrPasos);
	if(pasos == 1)
		printf("raiz\n-Encontrado\n");
	else
		printf("-No encontrado\n");
	printf("-Se ejecutaron %d pasos\n\n\n", *ptrPasos);

	n = 27;
	*ptrPasos = 0;
	printf("Prueba 2: El arbol está cargdo a la izquierda y el valor se encuentra en medio, el valor buscado es: %d\n", n);
	pasos = arbolDeBusqueda(arbolCargadoIzquierda, n, ptrPasos);
	if(pasos == 1)
		printf("raiz\n-Encontrado\n");
	else
		printf("-No encontrado\n");
	printf("-Se ejecutaron %d pasos\n\n\n", *ptrPasos);

	printf("**Arbol de Busqueda Binaria Balanceado**\n\nEstructura del arbol:\n");
	display_tree(arbolBalanceado);

	n = 24;
	*ptrPasos = 0;
	printf("\nPrueba 3: El arbol está balanceado y el valor se encuentra hasta el final, el valor buscado es: %d\n", n);
	pasos = arbolDeBusqueda(arbolBalanceado, n, ptrPasos);
	if(pasos == 1)
		printf("raiz\n-Encontrado\n");
	else
		printf("-No encontrado\n");
	printf("-Se ejecutaron %d pasos\n\n\n", *ptrPasos);

	n = 2;
	*ptrPasos = 0;
	printf("Prueba 2: El arbol está balanceado y el valor no se encuentra en el arbol, el valor buscado es: %d\n", n);
	pasos = arbolDeBusqueda(arbolBalanceado, n, ptrPasos);
	if(pasos == 1)
		printf("raiz\n-Encontrado\n");
	else
		printf("No encontrado\n");
	printf("-Se ejecutaron %d pasos\n\n\n", *ptrPasos);

	return 0;
}
