#include <stdio.h>

int main () {
    int n, t;
    char nomesAlunos[5000], frequencia[5000], saida[5000];
    char c;
    int q,w,e,r,y;
    
    scanf("%d", &t);
    scanf("%c", &c);

    while (t > 0){
        scanf("%d", &n);
        scanf("%c", &c);
        gets(nomesAlunos);
        gets(frequencia);
        saida[0] = '\0';
        q = 0;
        w = 0;
        e = 0;
        r = 0;
        y = 0;
        
        do {
            if (frequencia[q] == 'P')
                r++;
            else if (frequencia[q] == 'A')
                y++;
            else if (frequencia[q] == ' ' || frequencia[q] == '\0') {
            if (r < y * 3) {
                while (nomesAlunos[w] != ' ' && nomesAlunos[w] != '\0') {
                    saida[e] = nomesAlunos[w];
                    e++;
                    w++;
        }
            saida[e] = nomesAlunos[w];
            e++;
            w++;
            r = 0;
            y = 0;
        }
            else {
                while (nomesAlunos[w] != ' ') {
                w++;
        }
                w++;
                r = 0;
                y = 0;
        }
    }
            q++;
    }
        while (frequencia[q - 1] != '\0');
            saida[e - 1] = '\0';
            printf("%s\n", saida);
            t--;
    }
    }