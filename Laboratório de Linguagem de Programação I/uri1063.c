#include <stdio.h>
#define CONST 1002

struct pilha {
    char values[CONST];
    int n;
};

typedef struct pilha Pilha;

int main() {
    int nVagoes = 0, counter = 0, counter1 = 0;
    char inicio[CONST], fim[CONST];
    Pilha pilha;

    while (1) {
        scanf(" %d", &nVagoes);
        if (nVagoes == 0) {
            break;
        }

        for (counter = 0; counter < nVagoes; counter++) {
            scanf(" %c", &inicio[counter]);
        }

        for (counter = 0; counter < nVagoes; counter++) {
            scanf(" %c", &fim[counter]);
        }

        pilha.n = 0;
        counter = 0;
        counter1 = 0;

        while (1) {

            if ( (pilha.n != 0) && (counter1 < nVagoes) && (pilha.values[pilha.n - 1] == fim[counter1]) ) {
                pilha.n -= 1;
                printf("R");
                counter1 += 1;
            } 
            
            else if (counter < nVagoes) {
                pilha.values[pilha.n] = inicio[counter];
                pilha.n += 1;
                printf("I");
                counter += 1;
            } 
            
            else {
                break;
            }
        }

        if (pilha.n == 0) {
            printf("\n");
        } 
        
        else {
            printf(" Impossible\n");
        }
    }
    return 0;
}