#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main() {

    char senha[500];
    int bool1;
    int i, lenSenha, boolMaiusculas = 0, boolMinusculas = 0, boolEspeciais = 0, boolDigito = 0, boolEspaco = 0;


    while (scanf(" %[^\n]", senha) != EOF){
        lenSenha = strlen(senha);
        if (lenSenha <= 32 && lenSenha >= 6){
            bool1 = 1;

            for (i=0; i <= lenSenha; i+=1){
                if (isupper(senha[i]) != 0)boolMaiusculas += 1;
                else if (islower(senha[i]) != 0)boolMinusculas += 1;
                else if (isdigit(senha[i]) != 0)boolDigito += 1;
                else if (ispunct(senha[i]) != 0) boolEspeciais += 1;
                else if (senha[i] == ' ')boolEspaco += 1;
            }
            
            if (bool1 == 1 && boolDigito > 0 && boolMinusculas > 0 && boolMaiusculas > 0 && boolEspaco == 0 && boolEspeciais == 0){
                printf("Senha valida.\n");

            }else printf("Senha invalida.\n");


        }else printf("Senha invalida.\n");

        memset(senha, 0, sizeof(senha));
        bool1 = 0;
        boolMaiusculas = 0;
        boolMinusculas = 0;
        boolDigito = 0;
        boolEspeciais = 0;
        boolEspaco = 0;
    }
    return 0;
}