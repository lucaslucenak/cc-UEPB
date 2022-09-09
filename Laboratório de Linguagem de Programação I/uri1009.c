#include <stdio.h>
 
int main() {
 
    /**
     * Escreva a sua solução aqui
     * Code your solution here
     * Escriba su solución aquí
     */
char nomeVendedor;

double A,B;

scanf("%s",&nomeVendedor);

scanf("%lf %lf",&A,&B);

printf("TOTAL = R$ %.2f\n",(A+B*0.15)); 
    return 0;
}