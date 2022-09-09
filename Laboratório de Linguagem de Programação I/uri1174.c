#include <stdio.h>
#include <stdlib.h>

int main(){

    float A[100];
    int counter;

    for(counter = 0; counter <= 100; counter += 1){
        scanf("%f", &A[counter]);
    }

    for(counter = 0; counter <= 99; counter += 1){
        if(A[counter] <= 10){
            printf("A[%d] = %.1f\n", counter, A[counter]);
        }        
    }

    

    return 0;
}