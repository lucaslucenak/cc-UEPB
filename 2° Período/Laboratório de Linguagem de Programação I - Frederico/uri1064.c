#include <stdio.h>

int main() {

/*integrando as variaveis e os contadores*/
    int counterEntradas, counterNumPositivos;
    double soma;
    double numDigitado, media;
    soma = 0;
    counterNumPositivos = 0;
    counterEntradas = 0;

/*condicionais para validar a entrada dos valores inseridos nos contadores*/
while (counterEntradas <6){
    scanf("%lf", &numDigitado);
    counterEntradas += 1;
  
    if (numDigitado >= 0) {
        soma += numDigitado;
        counterNumPositivos += 1;
    }
}

/*calculo de media e exibicao requisitada*/
media = soma / counterNumPositivos;
      
    printf("%d valores positivos\n", counterNumPositivos);
    printf("%.1f\n", media);

    return 0;
}