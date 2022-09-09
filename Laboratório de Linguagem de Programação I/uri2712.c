#include <stdio.h>
#include <string.h>

int main(void) {
	int n, lenPlaca; 
	int verificadorHifen, verificadorNumeros, verificadorMaiusculas;
    n = lenPlaca = verificadorMaiusculas = verificadorNumeros = verificadorHifen = 0;
	char placa[101];

	scanf("%d", &n);

	while(n--) {
		scanf("%s", placa);

		lenPlaca = strlen(placa);

		if(lenPlaca == 8) {
			if(placa[0] >= 'A' && placa[0] <= 'Z') {
				if(placa[1] >= 'A' && placa[1] <= 'Z') {
					if(placa[2] >= 'A' && placa[2] <= 'Z') {
						verificadorMaiusculas = 1;
					}
				}
			}
		}

		if(placa[3] == '-' && verificadorMaiusculas == 1) {
			verificadorHifen = 1;
		}

		if(verificadorHifen == 1) {
			if(placa[4] >= '0' && placa[4] <= '9') {
				if(placa[5] >= '0' && placa[5] <= '9') {
					if(placa[6] >= '0' && placa[6] <= '9') {
						if(placa[7] >= '0' && placa[7] <= '9') {
							verificadorNumeros = 1;
						}
					}
				}
			}
		}

		if(verificadorNumeros == 1) {	
			if(placa[7] == '1' || placa[7] == '2') {
				printf("MONDAY\n");
			}else if(placa[7] == '3' || placa[7] == '4') {
				printf("TUESDAY\n");
			}else if(placa[7] == '5' || placa[7] == '6') {
				printf("WEDNESDAY\n");
			}else if(placa[7] == '7' || placa[7] == '8') {
				printf("THURSDAY\n");
			}else if(placa[7] == '9' || placa[7] == '0') {
				printf("FRIDAY\n");
			} 
		} else {
				printf("FAILURE\n");
			}

		verificadorHifen = verificadorMaiusculas = verificadorNumeros = 0;
	}

	return 0;
}