#include <stdio.h>

int main(void){
int contador, t;

scanf("%d", &t);
if (2 <= t <= 50){
    for(contador = 0; contador <= 999; contador += 1){
    printf("N[%d] = %d\n", contador, contador % t);
}    
}

    return 0;
}