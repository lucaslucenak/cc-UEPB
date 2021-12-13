#include <stdio.h>

int main() {

int codigoPeca1, codigoPeca2, quantidadePeca1, quantidadePeca2;
double valorPeca1, valorPeca2;

scanf("%d %d %lf",&codigoPeca1, &quantidadePeca1, &valorPeca1);
scanf("%d %d %lf",&codigoPeca2, &quantidadePeca2, &valorPeca2);

printf("VALOR A PAGAR: R$ %.2f\n", (quantidadePeca1 * valorPeca1) + (quantidadePeca2 * valorPeca2));
    return 0;
}