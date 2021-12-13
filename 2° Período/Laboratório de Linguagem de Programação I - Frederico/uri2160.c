#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

char formulario[501];
int contadorCaracteres;

gets(formulario);

contadorCaracteres = strlen(formulario);


if (strlen(formulario) <= 80)

    printf("YES\n");

    else
if (strlen(formulario) > 80)

    printf("NO\n");


    return 0;
}