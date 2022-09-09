/* Aluno: Lucas de Lucena Siqueira
   Matrícula: 201080354 */

#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <unistd.h>
#include <math.h>
#include <ctype.h>
#include <string.h>

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//%                                                               DECLARAÇÃO DAS FUNÇÕES                                                      %
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

void menu();
int verificarEntrada(char *entrada);
void invalido();
int FuncaoOpcao1(int qtdNumerosF);
int FuncaoOpcao2(float entrada2);
int Funcao_Menor_ou_Maior(int opcaoMenu, int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
void FuncaoOpcao5(int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
float FuncaoOpcao6(int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
float FuncaoOpcao7(int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
int FuncaoOpcao8(float valorMultiplicarF, int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
float FuncaoOpcao9(int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
int FuncaoOpcao10(int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
float FuncaoOpcao11(int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
void Funcao_Ordenar_Crescente_Decrescente(int opcaoMenu, int qtdNumerosF, float listaNumerosF[qtdNumerosF]);
int FuncaoOpcao14(char *textoF);
void FuncaoOpcao15(char *textoF);
void FuncaoOpcao16(char *textoF, int opcaoCriptografia);
void mostrarOpcoesCriptografia();
void FuncaoOpcao17(char *textoF, int opcaoCriptografia);
void FuncaoOpcao18();


//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//%                                                                   MAIN                                                                    %
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

int main() {
    setlocale(LC_ALL, "");
    char entrada[500];
    int opcaoMenu;
    int counter, boolCaractere0;

    //Variáveis da opção 1
    int qtdNumeros, boolOpcao1, boolCaractere1;
    float listaNumeros[qtdNumeros];
    char entrada1[500];

    //Variáveis da opção 2
    int counterForPrintOpcao2, boolOpcao2;
    char entrada2[500];
    int boolCaractere2, boolNumeroValido2;

    //Variáveis da opção 3
    float menorNumero;

    //Variáveis da opção 4
    float maiorNumero;

    //Variáveis da opção 6
    float counterSoma = 0;

    //Variáveis da opção 7
    float Multiplicacao = 1;

    //Variáveis da opção 8
    float valorMultiplicar;
    int boolOpcao8, boolCaractere8;
    char entrada8 [500];

    //Variáveis da opção 9
    float mediaAritmetica;

    //Variáveis da opção 10
    int NumerosAcimaMedia = 0;

    //Variáveis da opção 11
    double mediaPonderada = 0;

    //Variáveis da opção 12
    int i;

    //Variáveis da opção 13
    int r;

    //Variáveis da opção 14
    char texto[500];
    int boolOpcao14;
    int boolOpcao14a;

    //Variáveis da opção 16
    char entrada16[50];
    int opcaoCriptografia;
    int boolOpcao16;
    int boolUtilizado16;

    //Variáveis da opção 17
    int boolUtilizado17;


    do{
        //Permaneci com o sleep aqui professor, mas caso o senhor prefira, tem o system("cls") também, que vai limpar o terminal antes de retornar ao menu :)
        system("pause");
        system("cls");
        menu();

        //Verificação da entrada stdin do usuário
        while(1){
            while(1){
                printf("Opção: ");
                scanf("%s", &entrada);
                boolCaractere0 = verificarEntrada(entrada);

                if(boolCaractere0 == 1){
                    opcaoMenu = atoi(entrada);
                    break;
                }
                else{
                    printf("Opção inválida, escolha uma opção entre 1 e 18.\n");
                    continue;
                }
            }
            if(opcaoMenu < 1 || opcaoMenu > 18){
                printf("Opção inválida, escolha uma opção entre 1 e 18.\n");
                continue;
            }
            else{
                break;
            }
        }

//If Opção 1
        if (opcaoMenu == 1){
            printf("Quantos números você quer tratar?\n");
            printf("(A quantidade deve estar entre 5 e 15)\n");

        //Verificação da entrada stdin do usuário
        while(1){
            while(1){
                printf("Quantidade: ");
                scanf("%s", &entrada1);

                boolCaractere1 = verificarEntrada(entrada1);

                if (boolCaractere1 == 1){
                    qtdNumeros = atoi(entrada1);
                    break;
                }
                else{
                    printf("Caractere inválido!\n");
                    continue;
                }
            }

            boolOpcao1 = FuncaoOpcao1(qtdNumeros);
            if (boolOpcao1 == 1){
                break;
            }
            else{
                continue;
            }
        }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If Opção 2
        if (opcaoMenu == 2){
    //Caso o usuário tenha ido na opção 1 antes
            if (boolOpcao1 == 1){
                printf("Digite os %d números desejados abaixo\n", qtdNumeros);
                printf("Restrições:\n"
                "Os números informados devem estar entre -100 e 500, não sendo possível informar o número 0 ou algum múltiplo de 8\n");

        //Laço para o usuário informar os desejados
                for (counter = 0; counter < qtdNumeros; counter += 1){
                    boolOpcao2 = 1;

                    //Verificação da entrada stdin do usuário
                    while(1){
                        while(1){
                            printf("%d° Número: ", counter + 1);
                            scanf("%s", &entrada2);
                            boolCaractere2 = verificarEntrada(entrada2);

                            if (boolCaractere2 == 1){
                                listaNumeros[counter] = atoi(entrada2);
                                break;
                            }
                            else{
                                printf("Caractere inválido!\n");
                                continue;
                            }
                            printf("\n");
                        }

                        //Verificação dos números escolhidos
                        boolNumeroValido2 = FuncaoOpcao2(listaNumeros[counter]);

                        if (boolNumeroValido2 == 1){
                            break;
                        }
                        else{
                            printf("Número inválido!\n");
                            continue;
                        }
                    }
                }

        //Imprime os valores escolhidos
            printf("Os números escolhidos foram:\n");
            for (counterForPrintOpcao2 = 0; counterForPrintOpcao2 < qtdNumeros; counterForPrintOpcao2 += 1){
                printf("%.2f ", listaNumeros[counterForPrintOpcao2]);
            }
        printf("\n");
        printf("Retornando ao MENU\n\n");
        }

    //Caso o usuário vá na opção 2 do menu sem ter ido na 1 antes
            if (boolOpcao1 != 1){
                printf("É necessário determinar a quantidade de números antes, utilize a opção 1 primeiro.\n");
                printf("Retornando ao MENU...\n");
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If Opção 3
        if (opcaoMenu == 3){
    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){

            menorNumero = Funcao_Menor_ou_Maior(opcaoMenu, qtdNumeros, listaNumeros);

                printf("O menor número é: %.2f\n", menorNumero);
                printf("Retornando ao MENU...\n\n");
            }

    //Caso o úsuario não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 4
        if (opcaoMenu == 4){
    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){

                maiorNumero = Funcao_Menor_ou_Maior(opcaoMenu, qtdNumeros, listaNumeros);

                printf("O maior número é: %.2f\n", maiorNumero);
                printf("Retornando ao MENU...\n\n");
            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 5
        if (opcaoMenu == 5){

    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){

                printf("Digite o n-ésimo número da lista que desejas retornar:\n");
                FuncaoOpcao5(qtdNumeros, listaNumeros);
            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 6
        if (opcaoMenu == 6){
    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){
                counterSoma = FuncaoOpcao6(qtdNumeros, listaNumeros);

                printf("A soma dos números inseridos é: %.2f\n", counterSoma);
                printf("Retornando ao MENU...\n\n");
            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 7
        if (opcaoMenu == 7){
    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){
                Multiplicacao = FuncaoOpcao7(qtdNumeros, listaNumeros);

                printf("A multiplicação dos números é: %.2f\n", Multiplicacao);
                printf("Retornando ao MENU...\n\n");
            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 8
        if(opcaoMenu == 8){
    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){
                printf("Restrição: Não pode ser um número igual a ZERO.\n");
                printf("Digite o valor que você deseja multiplicar os números inseridos\n");

                //Verificação da entrada stdin do usuário
                while(1){
                    while(1){
                        printf("Valor: ");
                        scanf("%s", &entrada8);
                        boolCaractere8 = verificarEntrada(entrada8);
                        if(boolCaractere8 == 1){
                            valorMultiplicar = atoi(entrada8);
                            break;
                        }
                        else{
                            printf("Caractere inválido!\n");
                            continue;
                        }
                    }

                    boolOpcao8 = FuncaoOpcao8(valorMultiplicar, qtdNumeros, listaNumeros);

                    if(boolOpcao8 == 1){
                        break;
                    }
                    else{
                        continue;
                    }
                }
                printf("\nRetornando ao MENU...\n\n");
            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 9
        if(opcaoMenu == 9){
    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){
                mediaAritmetica = FuncaoOpcao9(qtdNumeros, listaNumeros);

            printf ("Média Aritmética: %.2f\n", mediaAritmetica);
            printf("Retornando ao MENU...\n\n");

            }
    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 10
        if (opcaoMenu == 10){
    //Caso o usuário tenha ido nas opções 1  2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){
                NumerosAcimaMedia = FuncaoOpcao10(qtdNumeros, listaNumeros);
                printf("Existem %d termos acima da média aritmética.\n", NumerosAcimaMedia);
                printf("Retornando ao MENU...\n\n");
            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 11
        if (opcaoMenu == 11){
    //Caso o usuário tenha ido nas opções 1  2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){

                mediaPonderada = FuncaoOpcao11(qtdNumeros, listaNumeros);

        //Imprime a média ponderada
                printf("Média ponderada: %.2lf\n", mediaPonderada);
                printf("Retornando ao MENU...\n\n");

            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 12
        if (opcaoMenu == 12){
    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){
//BubbleSort
            Funcao_Ordenar_Crescente_Decrescente(opcaoMenu, qtdNumeros, listaNumeros);

                printf("Números em ordem crescente:\n");
                for (i = 0; i < qtdNumeros; i++) {
                    printf("%.2f ", listaNumeros[i]);
                }
                printf("\nRetornando ao MENU...\n\n");
            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 13
        if (opcaoMenu == 13){
    //Caso o usuário tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 == 1 && boolOpcao2 == 1){

//BubbleSort
                Funcao_Ordenar_Crescente_Decrescente(opcaoMenu, qtdNumeros, listaNumeros);

                printf("Números em ordem decrescente:\n");
                for (r = 0; r < qtdNumeros; r++) {
                    printf("%.2f ", listaNumeros[r]);
            }
            printf("\n");
            printf("\nRetornando ao MENU...\n\n");
            }

    //Caso o usuário não tenha ido nas opções 1 e 2 antes
            if (boolOpcao1 != 1 || boolOpcao2 != 1){
                invalido();
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 14
        if (opcaoMenu == 14){
            boolUtilizado16 = 0;
            boolUtilizado17 = 0;
            printf("Condições: A string só pode conter letras maiúsculas ou minúsculas de (A) a (Z) e o espaço e não pode conter mais de 50 caracteres\n\n");
            while(1){
                printf("Digite a string: ");
                fflush(stdin);
                gets(texto);
                boolOpcao14 = FuncaoOpcao14(texto);

                if (boolOpcao14 == 1){
                    break;
                }
                else{
                    continue;
                }
            }
            boolOpcao14a = 1;
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 15
        if (opcaoMenu == 15){

            if (boolOpcao14a == 1){
                FuncaoOpcao15(texto);
            }
            else{
                printf("Utilize a opção 14 antes!\n");
                printf("Rertonando ao MENU...\n");
            }
        }
//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 16
        if (opcaoMenu == 16){
            if (boolOpcao14a == 1 && boolUtilizado16 == 0){
                printf("Opções de Criptografia: \n\n");
                sleep(1);
                mostrarOpcoesCriptografia();
                while(1){
                    while(1){
                        printf("Escolha a opção de Criptografia: ");
                        scanf("%s", entrada16);
                        boolOpcao16 = verificarEntrada(entrada16);

                        if (boolOpcao16 == 1){
                            opcaoCriptografia = atoi(entrada16);
                            break;
                        }
                        else{
                            printf("Caractere inválido!\n");
                            continue;
                        }
                    }
                    if (opcaoCriptografia > 0 && opcaoCriptografia < 6){
                        break;
                    }
                    else{
                        printf("Opção inválida!\n");
                        continue;
                    }
                }

                FuncaoOpcao16(texto, opcaoCriptografia);
                printf("Texto criptografado: %s\n", texto);
                printf("Retornando ao MENU\n\n");
                boolUtilizado16 = 1;
            }

            else{
                printf("Utilize a opção 14 antes!\n");
                printf("Rertonando ao MENU...\n");
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 17
        if (opcaoMenu == 17){
            if (boolOpcao14a == 1 && boolUtilizado17 == 0){
                FuncaoOpcao17(texto, opcaoCriptografia);
                printf("Texto descriptografado: %s\n", texto);
                boolUtilizado17 = 1;
            }
            else{
                printf("Utilize a opção 14 antes!\n");
                printf("Rertonando ao MENU...\n");
            }
        }

//---------------------------------------------------------------------------------------------------------------------------------------------

//If opção 18
        if (opcaoMenu == 18){
            FuncaoOpcao18();
            break;
        }

    } while (opcaoMenu != 18);
    return 0;
}

//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
//%                                                               FUNÇÕES                                                                     %
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


//Verificar caracteres
int verificarEntrada(char *entrada){
    int counter;
    int boolCaractere;

    for (counter = 0; counter < strlen(entrada); counter++){
        if (entrada[counter] >= '0' && entrada[counter] <= '9'){
            boolCaractere = 1;
        }
        else{
            boolCaractere = 0;
        }
    }
    return boolCaractere;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Mostrar Menu
void menu(){
            printf("MENU\n"
        " 1. Informar a quantidade de números que desejas tratar\n"
        " 2. Digitar os números desejados\n"
        " 3. Informar o menor número inserido\n"
        " 4. Informar o maior número inserido\n"
        " 5. Retornar um número específico da lista inserida\n"
        " 6. Calcular a soma dos números inseridos\n"
        " 7. Calcular o produto dos números inseridos\n"
        " 8. Multiplicar todos os números por um valor específico\n"
        " 9. Calcular a média aritmética dos números inseridos\n"
        "10. Informar quantos números estão acima da média arítmetica dos inseridos\n"
        "11. Calcular a média ponderada dos números inseridos\n"
        "12. Ordenar os números inseridos em ordem crescente\n"
        "13. Ordenar os números inseridos em ordem decrescente\n"
        "14. Digitar uma string\n"
        "15. Mostrar a string lida e seu respectivo tamanho\n"
        "16. Criptografar a string digitada\n"
        "17. Desincriptografar a string digitada\n"
        "18. Finalizar o programa\n\n");
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função de inválido (opção 3 a 13)
void invalido(){
    printf("É necessário determinar os números e a quantidade de números a serem tratados antes.\n"
    "Certifique-se que utilizou, respectivamente, as opções 1 e 2 corretamente antes.\n");
    printf("Retornando ao MENU...\n\n");
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 1
int FuncaoOpcao1(int qtdNumerosF){
    int boolOpcao1;

        if (qtdNumerosF >= 5 && qtdNumerosF <= 15){
            printf("Quantidade armazenada, voltando para o menu...\n\n");
            boolOpcao1 = 1;
        }
        else{
            printf("Quantidade inválida!\n");
        }
    return boolOpcao1;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 2
int FuncaoOpcao2(float entrada2){
    int boolNumero;

    if ( (entrada2 < -100) || (entrada2 > 500) || (entrada2 == 0) || (fmod(entrada2, 8) == 0)){
        boolNumero = 0;
    }
    else{
        boolNumero = 1;
    }
    return boolNumero;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 3 e 4
int Funcao_Menor_ou_Maior(int opcaoMenu, int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
    int counter;
    int numero;

    if(opcaoMenu == 3){
            numero = listaNumerosF[0];

        for (counter = 1; counter < qtdNumerosF; counter += 1){
            if (listaNumerosF[counter] < numero){
                numero = listaNumerosF[counter];
            }
        }
        return numero;

    }

    if(opcaoMenu == 4){
        numero = listaNumerosF[0];
        for (counter = 1; counter < qtdNumerosF; counter += 1){
            if (listaNumerosF[counter] > numero){
                numero = listaNumerosF[counter];
            }
        }
        return numero;

    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 5
void FuncaoOpcao5(int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
    int n, boolCaractere;
    char entrada5[500];

    boolCaractere = 0;
//Validações
    while(1){
        while(1){
            printf("N = ");
            scanf("%s", &entrada5);
            boolCaractere = verificarEntrada(entrada5);

            if (boolCaractere == 1){
                n = atoi(entrada5);
                break;
            }
            else{
                printf("\nCaractere inválido!\n");
                continue;
            }
        }
        printf("\n");
        if (n > qtdNumerosF || n <= 0){
            printf("Número inválido!\n");
            continue;
        }
        else{
            printf("O %d° número é: %.2f\n", n, listaNumerosF[n - 1]);
            printf("Retornando ao MENU...\n\n");
            break;
        }
    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 6
float FuncaoOpcao6(int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
    int counter;
    float counterSoma;

    counterSoma = 0;
    for (counter = 0; counter < qtdNumerosF; counter += 1){
        counterSoma += listaNumerosF[counter];
    }
    return counterSoma;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 7
float FuncaoOpcao7(int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
    int counter;
    float counterMultiplicacao;

    counterMultiplicacao = 1;
    for (counter = 0; counter < qtdNumerosF; counter += 1){
        counterMultiplicacao *= listaNumerosF[counter];
    }
return counterMultiplicacao;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 8
int FuncaoOpcao8(float valorMultiplicarF, int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
int boolOpcao8, counter, counterForPrintOpcao8;

    if (valorMultiplicarF == 0){
        printf("Valor igual a ZERO!\n");
    }

    //Caso o valor a multiplicar seja diferente de ZERO
    else{
    //Multiplica os números, alterando em memória
        for (counter = 0; counter < qtdNumerosF; counter += 1){
            listaNumerosF[counter] = listaNumerosF[counter] * valorMultiplicarF;
        }
    printf("Resultado: ");
        for (counterForPrintOpcao8 = 0; counterForPrintOpcao8 < qtdNumerosF; counterForPrintOpcao8 += 1){
            printf("%.2f ", listaNumerosF[counterForPrintOpcao8]);
        }
        boolOpcao8 = 1;
    }
    return boolOpcao8;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 9
float FuncaoOpcao9(int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
    int counter;
    float counterSomaOpcao9;
    float mediaAritmetica;
    counterSomaOpcao9 = 0;

    for (counter = 0; counter < qtdNumerosF; counter += 1){
        counterSomaOpcao9 += listaNumerosF[counter];
    }

    mediaAritmetica = counterSomaOpcao9 / qtdNumerosF;
    return mediaAritmetica;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 10
int FuncaoOpcao10(int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
    int counter1, counter, counterNumerosAcimaMedia;
    float counterSomaOpcao10, mediaAritmetica2;
    counterNumerosAcimaMedia = 0;
    counterSomaOpcao10 = 0;

    for (counter1 = 0; counter1 < qtdNumerosF; counter1 += 1){
        counterSomaOpcao10 += listaNumerosF[counter1];
    }

    mediaAritmetica2 = counterSomaOpcao10 / qtdNumerosF;

    for (counter = 0; counter < qtdNumerosF; counter += 1){
        if (listaNumerosF[counter] > mediaAritmetica2){
            counterNumerosAcimaMedia += 1;
        }
    }
    return counterNumerosAcimaMedia;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 11
float FuncaoOpcao11(int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
    int counter, counterForPrintOpcao2, boolCaractere11;
    float peso, somaPesos, counterSomaOpcao11, mediaPonderada;
    char entrada11[500];

    //Imprime os valores escolhidos
    printf("Os números escolhidos foram:\n");
        for (counterForPrintOpcao2 = 0; counterForPrintOpcao2 < qtdNumerosF; counterForPrintOpcao2 += 1){
            printf("%.2f ", listaNumerosF[counterForPrintOpcao2]);
        }
    printf("\n");

    //Recebe os pesos e calcula a média ponderada
    for (counter = 0; counter < qtdNumerosF; counter += 1){
            while(1){
                printf("Escolha o peso que o %d° número terá: ", counter + 1);
                scanf("%s", &entrada11);
                printf("\n");
                boolCaractere11 = verificarEntrada(entrada11);

                if(boolCaractere11 == 1){
                    peso = atoi(entrada11);
                    break;
                }
                else{
                    printf("Caractere inválido!\n");
                }
            }

        somaPesos += peso;
        counterSomaOpcao11 += listaNumerosF[counter] * peso;
    }
    mediaPonderada = counterSomaOpcao11 / somaPesos;

    return mediaPonderada;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 12 e 13
void Funcao_Ordenar_Crescente_Decrescente(int opcaoMenu, int qtdNumerosF, float listaNumerosF[qtdNumerosF]){
    int contador, i;
    float auxiliar;

    if(opcaoMenu == 12){
        for (contador = 1; contador < qtdNumerosF; contador++) {
            for (i = 0; i < qtdNumerosF - 1; i++) {
                if (listaNumerosF[i] > listaNumerosF[i + 1]) {
                    auxiliar = listaNumerosF[i];
                    listaNumerosF[i] = listaNumerosF[i + 1];
                    listaNumerosF[i + 1] = auxiliar;
                }
            }
        }
    }

    if(opcaoMenu == 13){
        for (contador = 1; contador < qtdNumerosF; contador += 1){
            for (i = 0; i < contador; i += 1){
                if (listaNumerosF[contador] > listaNumerosF[i]){
                    auxiliar = listaNumerosF[contador];
                    listaNumerosF[contador] = listaNumerosF[i];
                    listaNumerosF[i] = auxiliar;
                }
            }
        }
    }

}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 14
int FuncaoOpcao14(char *textoF){
    int i, boolInvalido = 0, lenTexto;
    int boolReturn = 0;
        lenTexto = strlen(textoF);

//Validações
        if (lenTexto <= 50){
            for (i = 0; i < lenTexto; i++){
                if (textoF[i] >= 'a' && textoF[i] <= 'z'){
                }
                else if (textoF[i] >= 'A' && textoF[i] <= 'Z'){
                }
                else if (textoF[i] == ' '){
                }
                else{
                    boolInvalido = 1;
                }
            }
        }
        else{
            boolInvalido = 1;
        }

        if (boolInvalido == 1){
            printf("Texto inválido!\n");
            boolInvalido = 0; //Contador zerado para futuras novas entradas
        }

        else{
            printf("Texto armazenado!\n");
            boolReturn = 1;
        }
    return boolReturn;
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 15
void FuncaoOpcao15(char *textoF){
    int lenTextoF;

        lenTextoF = strlen(textoF);
        printf("Texto armazenado: %s\n", textoF);
        printf("Tamanho do texto armazenado: %d caracteres\n", lenTextoF);
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 16
void FuncaoOpcao16(char *textoF, int opcaoCriptografia){
    char alfabeto[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char criptografia[] = "1234567890!@#$%:&*()-+<>/,12345";
    int i, j, k, lenTextoF;

    lenTextoF = strlen(textoF);

    //Deixa todos os caracteres maiúsuclos
    for (k = 0; k < lenTextoF; k++){
        textoF[k] = toupper(textoF[k]);
        }

    //Processo de criptografia
    for (i=0; i < lenTextoF; i++){
        for (j=0; j < 31; j++){
            if (textoF[i] == alfabeto[j]){
                textoF[i] = criptografia[j + (opcaoCriptografia - 1)];
            }
        }
    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 17
void FuncaoOpcao17(char *textoF,int opcaoCriptografia){
    char descriptografia[]="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char criptografia[]="1234567890!@#$%:&*()-+<>/,1234";
    int i, j, lenTextoF;

    j = opcaoCriptografia - 1;
    lenTextoF = strlen(textoF);


    for (i = 0; i < lenTextoF; i++){
        for (j = (opcaoCriptografia - 1); j < 31; j++){
            if (textoF[i] == criptografia[j]){
                textoF[i] = descriptografia[j - (opcaoCriptografia - 1)];
            }
        }
    }
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Função opção 18
void FuncaoOpcao18(){
    printf("Espero que o senhor esteja se recuperando/tenha se recuperado. Fique com Deus!\n");
    sleep(1);
    printf("Encerrando o programa.\n");
}

//---------------------------------------------------------------------------------------------------------------------------------------------

//Mostrar opções de Criptografia
void mostrarOpcoesCriptografia(){
    printf(
        "|-------------------| |-------------------| |-------------------| |-------------------| |-------------------|\n"
        "|      OPÇÃO 1      | |      OPÇÃO 2      | |      OPÇÃO 3      | |      OPÇÃO 4      | |      OPÇÃO 5      |\n"
        "|-------------------| |-------------------| |-------------------| |-------------------| |-------------------|\n"
        "| Caractere | Cifra | | Caractere | Cifra | | Caractere | Cifra | | Caractere | Cifra | | Caractere | Cifra |\n"
        "|     A     |   1   | |     A     |   2   | |     A     |   3   | |     A     |   4   | |     A     |   5   |\n"
        "|     B     |   2   | |     B     |   3   | |     B     |   4   | |     B     |   5   | |     B     |   6   |\n"
        "|     C     |   3   | |     C     |   4   | |     C     |   5   | |     C     |   6   | |     C     |   7   |\n"
        "|     D     |   4   | |     D     |   5   | |     D     |   6   | |     D     |   7   | |     D     |   8   |\n"
        "|     E     |   5   | |     E     |   6   | |     E     |   7   | |     E     |   8   | |     E     |   9   |\n"
        "|     F     |   6   | |     F     |   7   | |     F     |   8   | |     F     |   9   | |     F     |   0   |\n"
        "|     G     |   7   | |     G     |   8   | |     G     |   9   | |     G     |   0   | |     G     |   !   |\n"
        "|     H     |   8   | |     H     |   9   | |     H     |   0   | |     H     |   !   | |     H     |   @   |\n"
        "|     I     |   9   | |     I     |   0   | |     I     |   !   | |     I     |   @   | |     I     |   #   |\n"
        "|     J     |   0   | |     J     |   !   | |     J     |   @   | |     J     |   #   | |     J     |   $   |\n"
        "|     K     |   !   | |     K     |   @   | |     K     |   #   | |     K     |   $   | |     K     |   %%   |\n"
        "|     L     |   @   | |     L     |   #   | |     L     |   $   | |     L     |   %%   | |     L     |   :   |\n"
        "|     M     |   #   | |     M     |   $   | |     M     |   %%   | |     M     |   :   | |     M     |   &   |\n"
        "|     N     |   $   | |     N     |   %%   | |     N     |   :   | |     N     |   &   | |     N     |   *   |\n"
        "|     O     |   %%   | |     O     |   :   | |     O     |   &   | |     O     |   *   | |     O     |   (   |\n"
        "|     P     |   :   | |     P     |   &   | |     P     |   *   | |     P     |   (   | |     P     |   )   |\n"
        "|     Q     |   &   | |     Q     |   *   | |     Q     |   (   | |     Q     |   )   | |     Q     |   -   |\n"
        "|     R     |   *   | |     R     |   (   | |     R     |   )   | |     R     |   -   | |     R     |   +   |\n"
        "|     S     |   (   | |     S     |   )   | |     S     |   -   | |     S     |   +   | |     S     |   <   |\n"
        "|     T     |   )   | |     T     |   -   | |     T     |   +   | |     T     |   <   | |     T     |   >   |\n"
        "|     U     |   -   | |     U     |   +   | |     U     |   <   | |     U     |   >   | |     U     |   /   |\n"
        "|     V     |   +   | |     V     |   <   | |     V     |   >   | |     V     |   /   | |     V     |   ,   |\n"
        "|     W     |   <   | |     W     |   >   | |     W     |   /   | |     W     |   ,   | |     W     |   1   |\n"
        "|     X     |   >   | |     X     |   /   | |     X     |   ,   | |     X     |   1   | |     X     |   2   |\n"
        "|     Y     |   /   | |     Y     |   ,   | |     Y     |   1   | |     Y     |   2   | |     Y     |   3   |\n"
        "|     Z     |   ,   | |     Z     |   1   | |     Z     |   2   | |     Z     |   3   | |     Z     |   4   |\n"
        "|-------------------| |-------------------| |-------------------| |-------------------| |-------------------|\n"
        "\n");
}