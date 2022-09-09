#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <string.h>

#define MAX1 21
#define MAX2 31
#define MAIOR_QTD(a, b) a > b ? a : b

typedef struct{
    int tempo;
    int pizzas;}
    TPedido;

int main(){
	TPedido pedido[MAX1];
	int matriz[MAX1][MAX2];
    int n, qtdPizzas, counter, counter1;
	
	while(scanf("%d", &n) && n){
		scanf(" %d", &qtdPizzas);

		for(counter = 1; counter <= n; counter++)
			scanf("%d %d", &pedido[counter].tempo, &pedido[counter].pizzas);
		
		for(counter = 0; counter <= n; counter++)
			for(counter1 = 0 ; counter1 <= qtdPizzas; counter1++)
				if(!counter || !counter1)
					matriz[counter][counter1] = 0;
                    else if(pedido[counter].pizzas > counter1) 
						matriz[counter][counter1] = matriz[counter - 1][counter1];

					else
						matriz[counter][counter1] = MAIOR_QTD(matriz[counter - 1][counter1 - pedido[counter].pizzas] + pedido[counter].tempo, matriz[counter - 1][counter1]);
					
		printf("%d min.\n", matriz[n][qtdPizzas]);
	}
	return 0;
}
