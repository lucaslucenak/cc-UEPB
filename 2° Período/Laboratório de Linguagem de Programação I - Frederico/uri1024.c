#include <stdio.h>
#include <string.h>

int main(){

    char palavra[1100], palavraManipulada;
    int casos;
    int counter, counter1, lenPalavra, lenPalavraMetade;

    scanf("%d", &casos);


    while (casos){

        scanf(" %[^\n]", palavra);

        lenPalavra = strlen(palavra);
        lenPalavraMetade = lenPalavra/2;

            //Primeira parte
        for (counter = 0; counter < lenPalavra; counter += 1 ){
            if ((palavra[counter] >= 'A' && palavra[counter] <= 'Z') || (palavra[counter] >= 'a' && palavra[counter] <= 'z'))
                palavra[counter] = palavra[counter] + 3;
}

            //Segunda parte
        for (counter = 0, counter1 = lenPalavra - 1; counter < lenPalavraMetade; counter += 1, counter1 -= 1){
            palavraManipulada = palavra[counter1];
            palavra[counter1] = palavra[counter];
            palavra[counter] = palavraManipulada;
}
    
            //Terceira parte
        for (counter = lenPalavraMetade; counter < lenPalavra; counter += 1 ){
            if ((palavra[counter] >= 32 && palavra[counter] <= 176 ))
                palavra[counter] = palavra[counter] - 1;
}


    printf("%s\n", palavra);

    //Resetar a palavra
    memset(palavra, 0 , sizeof(palavra));

    casos -= 1;
}
}