#include <stdio.h>
#include <stdlib.h>
#include <string.h> //strcmp

int main()
{
    //Incluindo variáveis (contador; número de partidas; opções de jogada; jogadores (Sheldon e Raj))
    int N_partidas, counter;
    char tesoura[]="tesoura", papel[]="papel", pedra[]="pedra", lagarto[]="lagarto", spock[]="Spock";
    char Sheldon[10],Raj[10];

    //Recebendo a quantidade de partidas a serem feitas
    scanf("%d", &N_partidas);

    //Laço "For" que controla a quantidade de partidas
    for(counter = 1; counter <= N_partidas; counter++){

        //Recebendo as opções de jogada do Sheldon e do Raj
        scanf("%s %s", Sheldon, Raj);



        //Comparação caso Sheldon e Raj façam a mesma coisa
        if(strcmp(Sheldon, Raj) == 0)
            printf("Caso #%d: De novo!\n", counter);


        //Caso Sheldon escolha Tesoura
        else if(strcmp(Sheldon, tesoura) == 0){

            //Caso Sheldon Ganhe
            if((strcmp(Raj, papel) == 0) || (strcmp(Raj, lagarto) == 0))
                printf("Caso #%d: Bazinga!\n", counter);

            //Caso Sheldon Perca
            else if((strcmp(Raj, pedra) == 0) || (strcmp(Raj, spock) == 0))
                printf("Caso #%d: Raj trapaceou!\n", counter);
        }


        //Caso Sheldon escolha Papel
        else if(strcmp(Sheldon, papel) == 0){

            //Caso Sheldon Ganhe
            if((strcmp(Raj, pedra) == 0) || (strcmp(Raj, spock) == 0))
                printf("Caso #%d: Bazinga!\n", counter);

            //Caso Sheldon Perca
            else if((strcmp(Raj, tesoura) == 0) || (strcmp(Raj, lagarto) == 0))
                printf("Caso #%d: Raj trapaceou!\n", counter);
        }

        //Caso Sheldon escolha Pedra
        else if(strcmp(Sheldon, pedra) == 0){

            //Caso Sheldon Ganhe
            if((strcmp(Raj, tesoura) == 0) || (strcmp(Raj, lagarto) == 0))
                printf("Caso #%d: Bazinga!\n", counter);

            //Caso Sheldon Perca
            else if((strcmp(Raj, papel) == 0) || (strcmp(Raj, spock) == 0))
                printf("Caso #%d: Raj trapaceou!\n", counter);
        }

        //Caso Sheldon escolha Lagarto
        else if(strcmp(Sheldon, lagarto) == 0){

            //Caso Sheldon Ganhe
            if((strcmp(Raj, papel) == 0) || (strcmp(Raj, spock) == 0))
                printf("Caso #%d: Bazinga!\n", counter);

            //Caso Sheldon Perca
            else if((strcmp(Raj, pedra) == 0) || (strcmp(Raj, tesoura) == 0))
                printf("Caso #%d: Raj trapaceou!\n", counter);
        }

        //Caso Sheldon escolha Spock
        else if(strcmp(Sheldon, spock) == 0){

            //Caso Sheldon Ganhe
            if((strcmp(Raj, tesoura) == 0) || (strcmp(Raj, pedra) == 0))
                printf("Caso #%d: Bazinga!\n", counter);

            //Caso Sheldon Perca
            else if((strcmp(Raj, papel) == 0) || (strcmp(Raj, lagarto) == 0))
                printf("Caso #%d: Raj trapaceou!\n", counter);
        }
    }
    return 0;
}