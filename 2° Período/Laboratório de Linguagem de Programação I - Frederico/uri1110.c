#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <ctype.h>

struct Cartas{
    char carta;
	struct Cartas *prox;
};

typedef struct Cartas TCartas;

struct descrPilha{
    TCartas *topo, *final;
	int qtd;
};

typedef struct descrPilha DPilha;

int main(){
	int vDescart[55], Cqtd, counter=0, counter1=0;
	DPilha	descritor;
	TCartas *aux;

	while (scanf("%d", &Cqtd) && Cqtd != 0){
		for(counter = 0; counter < 55; counter++)
			vDescart[counter] = 0;

		counter1 = 0;

		descritor.topo = NULL;
		descritor.qtd = 0;

		for(counter = Cqtd; counter > 0; counter--){
			aux = (TCartas *) malloc(sizeof(TCartas));

			if(aux == NULL)
				break;

			aux->carta = counter;
			aux->prox = descritor.topo;

			descritor.topo = aux;
			descritor.qtd++;

			if(counter == Cqtd)
				descritor.final = aux;
		}

		while (descritor.qtd >= 2){
			aux = descritor.topo;
			descritor.topo = aux -> prox;
			vDescart[counter1] = aux -> carta;

			free(aux);
			descritor.qtd--;
			counter1 += 1;
            
			aux = descritor.topo->prox;
			descritor.final->prox = descritor.topo;
			descritor.final = descritor.topo;
			descritor.topo = aux;
		}

		printf("Discarded cards:");
		for(counter = 0; counter < counter1; counter++){
			printf(" %d", vDescart[counter]);

			if(counter != counter1 - 1)
				printf(",");
		}

		printf("\nRemaining card: %d\n", descritor.final->carta);
	}

	return 0;
}