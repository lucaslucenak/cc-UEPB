#include <stdio.h>
#include <stdlib.h>

#define MAX 50002

#define D 1
#define E -1

int triangulo(const int *COLUNAS, int indice, int tamanho);
int altura(const int *COLUNAS, int indice, int tamanho, int direcao);


int main (void){
    int num, COLUNAS[MAX], counter, counter1, colunaMaior, colunaMaior_laco;

    scanf(" %d", &num);

    for (counter = 0; counter < num; counter++){
        scanf(" %d", COLUNAS + counter);
    }

    colunaMaior = 1;
    colunaMaior_laco = 1;

    for (counter = 2; counter <= num; counter++){
        for (counter1 = counter - 1; counter1 <= num - counter; counter1++){
            if (triangulo(COLUNAS, counter1, counter)){
                colunaMaior_laco = counter;
                break;
            }
        }
       
        if (colunaMaior == colunaMaior_laco){
            break;
        }
        colunaMaior = colunaMaior_laco;
    }

    printf("%d\n", colunaMaior);

    return 0;
}

int triangulo(const int *COLUNASf, int counterF, int tamanhoF){

    if (COLUNASf[counterF] >= tamanhoF){
        return altura(COLUNASf, counterF - 1, tamanhoF - 1, E) && altura(COLUNASf, counterF + 1, tamanhoF - 1, D);
    }

    else{
        return 0;
    }
}

int altura(const int *COLUNASf, int counterF, int tamanhoF, int direcionamentoF){
    if (tamanhoF == 1){
        return 1;
    }

    else if (COLUNASf[counterF] >= tamanhoF){
        return altura(COLUNASf, counterF + direcionamentoF, tamanhoF - 1, direcionamentoF);
    }

    else{
        return 0;
    }
}