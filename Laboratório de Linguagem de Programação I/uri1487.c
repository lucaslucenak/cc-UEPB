#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct brinquedo{

	unsigned short tempo_struct;
	unsigned short pontos_struct;
	double proporcao_struct;

} brinquedo;

int compara(brinquedo *a, brinquedo *b);

int main (){
	int counter;
	unsigned short momento;
	unsigned short qtd, tempoL, auxiliar;
	unsigned short pontos, tempoT;

	momento = 0;

	while (true){
		scanf("%hu %hu", &qtd, &tempoL);

		if (qtd == 0)
			break;
		brinquedo brinquedos[qtd];

		for (counter = 0; counter < qtd; counter++){
			scanf("%hu %hu", &brinquedos[counter].tempo_struct, &brinquedos[counter].pontos_struct);
			brinquedos[counter].proporcao_struct = (brinquedos[counter].pontos_struct / (double)brinquedos[counter].tempo_struct);
		}

		qsort(brinquedos, qtd, sizeof(brinquedo), compara);

		counter = 0;
		pontos = tempoT = 0;

		while (counter < qtd){
			auxiliar = tempoT + brinquedos[counter].tempo_struct;

			if (auxiliar <= tempoL){
				pontos += brinquedos[counter].pontos_struct;
				tempoT = auxiliar;
			}
			else
				counter += 1;
		}
		printf("Instancia %hu\n%hu\n\n", momento += 1, pontos);
	}
    return 0;
}

int compara(brinquedo *a, brinquedo *b){
	if (a -> proporcao_struct == b -> proporcao_struct)
		return 0;

	else if (a -> proporcao_struct > b -> proporcao_struct)
		return -1;

	else
		return 1;
}