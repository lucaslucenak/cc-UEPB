#include <stdio.h>
#include <string.h>

int main(){
    int nPalavras, linhasPag, caracLinhas;
    char conto[100001];
    int i, lenConto, linhas, paginas, caract, maximo;
   
    while(scanf("%d%d%d", &nPalavras, &linhasPag, &caracLinhas) != EOF){
        getchar();
        fgets(conto, 100001, stdin);

        lenConto = strlen(conto) - 1;    
		linhas = paginas = 1;
		caract = maximo = 0;
        
        for(i = 0; i < lenConto; ++i){
            if(i && conto[i - 1] == ' '){
            	maximo = i;
			}
            if(caract == caracLinhas){
                ++linhas;
                if(conto[i] == ' '){
                    caract = 0;
                }
                else{
                	caract = i - maximo + 1;
				}       
            }
            else{
            	++caract;
			}   
        }
        paginas = linhas / linhasPag + (linhas % linhasPag > 0);
        printf("%d\n", paginas);
    }

    return 0;
}