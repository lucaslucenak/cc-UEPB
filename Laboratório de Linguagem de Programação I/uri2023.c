#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

int comparador(char const *a, char const *b);
int comparar_1(const void *a, const void *b);


int main(){
    char criancas[1000][101];
    int qtd_criancas = 0;

    while (fgets(criancas[qtd_criancas], 101, stdin))
        qtd_criancas += 1;

    qsort(criancas, qtd_criancas, 101, comparar_1);

    printf("%s", criancas[0]);

    return 0;
}

int comparador(char const *a, char const *b){
    for (;; a++, b++) {
        int d = tolower(*a) - tolower(*b);
        if (d != 0 || !*a)
            return d;
    }
}

int comparar_1(const void *a, const void *b){
    const char *s1 = (const char *) a;
    const char *s2 = (const char *) b;

    return comparador(s2, s1);
}