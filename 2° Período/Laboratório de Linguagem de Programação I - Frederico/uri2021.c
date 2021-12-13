#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){

double valorInserido;
int nota100, nota50, nota20, nota10, nota5, nota2, moeda1_00;
int moeda50, moeda25, moeda10, moeda5, moeda1;

scanf("%lf", &valorInserido);

//Calculo notas e moeda de R$1:
nota100 = valorInserido / 100;
nota50 = (fmod(valorInserido, 100) / 50);
nota20 = ((fmod((fmod(valorInserido, 100)), 50)) / 20);
nota10 = ((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)) / 10);
nota5 = ((fmod((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)), 10) / 5));
nota2 = ((fmod((fmod((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)), 10)), 5) / 2));

//Calculo moedas:
moeda1_00 = ((fmod((fmod((fmod((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)), 10)), 5)), 2) / 1));
moeda50   = ((fmod((fmod((fmod((fmod((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)), 10)), 5)), 2)), 1) / 0.5));
moeda25   = ((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)), 10)), 5)), 2)), 1)), 0.5) / 0.25));
moeda10   = ((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)), 10)), 5)), 2)), 1)), 0.5)), 0.25) / 0.1));
moeda5    = ((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)), 10)), 5)), 2)), 1)), 0.5)), 0.25)), 0.1) / 0.05));
moeda1    = round(((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod((fmod(valorInserido, 100)), 50)), 20)), 10)), 5)), 2)), 1)), 0.5)), 0.25)), 0.1)), 0.05) / 0.01)));



//Imprimindo as notas:
printf("NOTAS:\n");
printf("%d nota(s) de R$ 100.00\n", nota100);
printf("%d nota(s) de R$ 50.00\n", nota50);
printf("%d nota(s) de R$ 20.00\n", nota20);
printf("%d nota(s) de R$ 10.00\n", nota10);
printf("%d nota(s) de R$ 5.00\n", nota5);
printf("%d nota(s) de R$ 2.00\n", nota2);

//Imprimindo as moedas:
printf("MOEDAS:\n");
printf("%d moeda(s) de R$ 1.00\n", moeda1_00);
printf("%d moeda(s) de R$ 0.50\n", moeda50);
printf("%d moeda(s) de R$ 0.25\n", moeda25);
printf("%d moeda(s) de R$ 0.10\n", moeda10);
printf("%d moeda(s) de R$ 0.05\n", moeda5);
printf("%d moeda(s) de R$ 0.01\n", moeda1);

    return 0;
}