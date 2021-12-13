#include <stdio.h>
#include <string.h>

int main(){
    char vogais[500], frase[5000];
    int counter = 0, i, j;
    int lenVogais, lenFrase;

    while (gets(vogais) && gets(frase) != EOF){
        lenVogais = strlen(vogais);
        lenFrase = strlen(frase);
        if (vogais[0] < ' '){
            break;
        }

        for (i = 0; i < lenVogais; i += 1){
            for (j = 0; j < lenFrase; j += 1){
                if (vogais[i] == frase[j]){
                    counter += 1;
                    //printf("uma igual\n");
                }
            }
        }
        printf("%d\n", counter);
        counter = 0;
    }
    return 0;
}