#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool verificador (char *);

int main (){
	char texto[1100];

    fflush(stdin);
	while (scanf("%s", texto) != EOF){
        fflush(stdin);
		if(verificador(texto))
			printf("correct\n");

		else
			printf("incorrect\n");
	}
    return 0;
}

bool verificador(char *str){
	short quantidade = 0;

	if (*str == ')')
		return false;

	while ((*str) && (quantidade >= 0)){

		if (*str == '(')
			quantidade += 1;

		if (*str == ')')
			quantidade -= 1;
		str++;
	}

	if (quantidade == 0)
		return true;

	else
		return false;
}