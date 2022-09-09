#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int main(){

	char entrada[300001], assinaturaArtista[10];
	int counter = 1;

	while(true){

		scanf("%s", assinaturaArtista);

		    if (strcmp(assinaturaArtista, "0") == 0){
			    break;
}

		    if (counter != 1){
			    printf("\n");
}

		    scanf(" %s", entrada);

		    if (strstr(entrada, assinaturaArtista)){
			    printf("Instancia %d\n", counter);
			    printf("verdadeira\n");
}

		    else{
			    printf("Instancia %d\n", counter);
			    printf("falsa\n");

}

		counter += 1;

}
  return 0;
}