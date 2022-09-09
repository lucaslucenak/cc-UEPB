#include <stdio.h>

#include <string.h>


int main(){
    char str1[51], str2[51];
    while (scanf("%[^\n]s", str1) != EOF){
        getchar();
        scanf("%[^\n]s", str2);
        getchar();
        int i, j, tamStr1, tamStr2;
        int tamMaiorSeq = 0;
        int tamSeq;
        tamStr1 = strlen(str1);
        tamStr2 = strlen(str2);
        for (i = 0; i < tamStr1; i++){
            for (j = 0; j < tamStr2; j++){
                tamSeq = 0;   
                if (str1[i] == str2[j]){
                    tamSeq++;                   
                    while ((str1[tamSeq + i] == str2[tamSeq + j]) && (( tamSeq + i) < tamStr1)){
                        tamSeq++;
                    }
                }
                if (tamSeq > tamMaiorSeq){
                    tamMaiorSeq = tamSeq;
                }
            }
        }
        printf("%d\n", tamMaiorSeq);

    }

    return 0;

}