#include<stdio.h>
#include<string.h>

#define Ubound 48
#define CONST(a,b) (a) > (b) ? (a) : (b)

void dfs(int sat,int posicao,int maximo);

int a[Ubound+1][Ubound+1];
int pedras,d;

void main() {
	int i, j;
	memset(a, 0, sizeof(a));
	dfs(2, 1, 1);
	while(scanf("%d%d", &pedras, &d), pedras + d){
        
		if(pedras > Ubound) puts("Let me try!");
		else
			if(a[d][pedras]) puts("Let me try!");

			else puts("Don't make fun of me!");
	}
}

void dfs(int sat,int posicao,int maximo) {
	int j = 2*  sat - 1, i;

	if(posicao > Ubound || posicao <= 0) return;

	if(!a[posicao][maximo])

		for(i = maximo; i <= Ubound; i++)
			a[posicao][i] = 1;

	dfs(sat + 1, posicao+  j, CONST(posicao + j, maximo));
	dfs(sat + 1, posicao - j, maximo);
}