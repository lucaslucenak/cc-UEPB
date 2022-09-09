#include <stdio.h>

int main() {
  int idadeDias;
  scanf("%d", &idadeDias);

  printf("%d ano(s)\n", (idadeDias / 365));
  printf("%d mes(es)\n", (idadeDias % 365) / 30);
  printf("%d dia(s)\n", (idadeDias % 365) % 30);


    return 0;
}