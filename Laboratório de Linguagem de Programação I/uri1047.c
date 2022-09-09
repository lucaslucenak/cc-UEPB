#include <stdio.h>

int main(){
    int hI, mI, hF, mF, somaI, somaF;
    int duracaoSeg, horasTotal, minutosTotal;

    scanf("%d %d %d %d", &hI, &mI, &hF, &mF);

    if (hF <= hI && mF <= mI){
        hF += 24;
} 
    else if (mF <= mI){
        mF += 60;
        hF -= 1;
}

    somaI = (hI * 3600) + (mI * 60); //em segundos
    somaF = (hF * 3600) + (mF * 60); //em segundos

    duracaoSeg = (somaF - somaI);
    horasTotal = duracaoSeg / 3600;
    minutosTotal = (duracaoSeg - (horasTotal * 3600)) / 60;
    printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n", horasTotal, minutosTotal);

    return 0;
}