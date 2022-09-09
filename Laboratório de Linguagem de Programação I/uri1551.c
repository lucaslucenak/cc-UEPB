#include <stdio.h>
#include <string.h>
#include <ctype.h>

int main()
{
    int n;

    scanf("%d", &n);
    getchar();
    int count;

    for (count = 0; count < n; count++){
        char frase[1002];
        int i, lenFrase, letters, verifLetra[26];


        fgets(frase, 1002, stdin);

        lenFrase = strlen(frase);

        for (i = 0; i < lenFrase; ++i) {
            if (isalpha(frase[i]))
                verifLetra[frase[i] - 'a'] = 1;
        }

        for (i = 0, letters = 0; i < 26; ++i)
            letters += verifLetra[i];

        if (letters == 26)
            printf("frase completa\n");
        else if (letters >= 13)
            printf("frase quase completa\n");
        else
            printf("frase mal elaborada\n");

        memset(verifLetra, 0, sizeof(verifLetra));
    }

    return 0;
}