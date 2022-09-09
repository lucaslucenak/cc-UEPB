#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct itemS Item;
typedef struct pilhaS Pilha;

struct itemS {
    char info;
    Item *anterior;
};

struct pilhaS {
    Item *inicio;
};

Pilha *empilhar();
Item *fazerItem(char);
Item *desempilhar(Pilha *);
void empilha(Pilha *, Item *);


int main() {
    Pilha *pilha = empilhar();
    Item *remover;
    char RNAalien[301];
    int i, nLigacoes;

    while(scanf(" %s", RNAalien) != EOF) {
        i = 0;
        nLigacoes = 0;

        while(i < strlen(RNAalien)) {

            if (pilha -> inicio == NULL || ((pilha -> inicio -> info == 'B' && RNAalien[i] != 'S') || (pilha -> inicio -> info == 'S' && RNAalien[i] != 'B') || (pilha -> inicio -> info == 'C' && RNAalien[i] != 'F') || (pilha -> inicio -> info == 'F' && RNAalien[i] != 'C'))) {
                empilha(pilha, fazerItem(RNAalien[i]));
            } 
            
            else {
                nLigacoes += 1;
                remover = desempilhar(pilha);
                free(remover);
            }

            i+= 1;
        }
        printf("%d\n", nLigacoes);

        while (pilha -> inicio != NULL) {
            remover = desempilhar(pilha);
            free(remover);
        }
    }
    return 0;
}

Pilha *empilhar() {
    Pilha *pilha = (Pilha*) malloc(sizeof(Pilha));
    if (pilha != NULL) {
        pilha -> inicio = NULL;
    }
    return pilha;
}

Item *fazerItem(char infoF) {
    Item *item = (Item*)malloc(sizeof(Item));
    if(item != NULL) {
        item -> info = infoF;
        item -> anterior = NULL;
    }
    return item;
}

void empilha(Pilha *pilhaF, Item *item) {
    item -> anterior = pilhaF -> inicio;
    pilhaF -> inicio = item;
}

Item *desempilhar(Pilha *pilhaF) {
    Item *removido = pilhaF -> inicio;
    if(pilhaF -> inicio != NULL) {
        pilhaF -> inicio = removido -> anterior;
        removido -> anterior = NULL;
    }
    return removido;
}