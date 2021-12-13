#include <stdio.h>
#include <math.h>

int qtdTorres, qtdBolas, counter;
int capacidadeTorres[51];
int t, i, j;

void max(int numeroBola, int p);

int main(){

    scanf("%d", &t);

    for(i = 1; i <= t; i++) {
        scanf("%d", &qtdTorres);

        for(j = 0; j < 50; j++)
			capacidadeTorres[j]= 0;		 
            qtdBolas = 0;
            max(1, 0);
            printf("%d\n", qtdBolas);
    }
    
    return 0;
}

void max(int numeroBola, int posicao){

    if(posicao == qtdTorres){
        return;
    }

    if(capacidadeTorres[posicao] == 0){
        capacidadeTorres[posicao] = numeroBola;
        qtdBolas += 1;
        return max(numeroBola+1, posicao);
    }

    for(counter = 0; counter <= posicao; counter++){
        int raiz = (int) sqrt(capacidadeTorres[counter] + numeroBola);

        if(pow(raiz,2) == capacidadeTorres[counter] + numeroBola) {	
            capacidadeTorres[counter] = numeroBola;
            qtdBolas += 1;
            return max(numeroBola + 1, posicao);
        }

    }
    max(numeroBola, posicao + 1);
}