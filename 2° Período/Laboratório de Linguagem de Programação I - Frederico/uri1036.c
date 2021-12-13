#include <stdio.h>
#include <math.h>
#include <stdlib.h>

int main(){
    double A, B, C;
    double bhaskaraR1, bhaskaraR2, raiz, calculoDentroRaiz, divisor;

    scanf("%lf %lf %lf", &A, &B, &C);

    calculoDentroRaiz = B * B - 4 * A * C;
    raiz = sqrt(calculoDentroRaiz);
    divisor = 2 * A;
    bhaskaraR1 = (-B + raiz) / divisor;
    bhaskaraR2 = (-B - raiz) / divisor;

    if(calculoDentroRaiz < 0 || divisor == 0){
        printf("Impossivel calcular\n");
    }
    
    else{
        printf("R1 = %.5lf\n", bhaskaraR1);
        printf("R2 = %.5lf\n", bhaskaraR2);
    }
    return 0;

}