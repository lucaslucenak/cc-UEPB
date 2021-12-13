#include <stdio.h>
#include <string.h>

int main(){

    char palavra[101];
    int i, j, lenPalavra, espaco;

    while(scanf("%s",palavra)!=EOF){

    lenPalavra = strlen(palavra);
    for (j = 0; j <= strlen(palavra) - 1; j++){
        for (espaco = 0; espaco < j; espaco++){
            printf(" ");
    }
   for (i = 0; i < lenPalavra; i++){
        printf("%c",palavra[i]);
        if (i < lenPalavra - 1)
            printf(" ");
   }
   
   lenPalavra--;

   printf("\n");
    }

  printf("\n");
}
    return 0;
}