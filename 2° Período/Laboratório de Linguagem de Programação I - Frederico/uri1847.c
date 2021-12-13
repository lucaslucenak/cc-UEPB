#include <stdio.h>
#include <stdlib.h>


int main(){



int a, b, c;
scanf("%d %d %d", &a, &b, &c);

if ((a > b) && (b < c)){
    printf(":)\n");
}

if ((a > b) && (b == c)){
    printf(":)\n");
}

if ((a < b) && (b > c)){
    printf(":(\n");
}

if ((a < b) && (b == c)){
    printf(":(\n");
}

if ((a < b) && (b < c) && ((c - b) < (b - a))){
    printf(":(\n");
}

if ((a < b) &&  (b < c) && ((c - b) >= (b - a))){
    printf(":)\n");
}

if ((a > b) && (b > c) && ((b - c) < (a - b))){
    printf(":)\n");
}

if ((a > b) && (b > c) && ((b - c) >= (a - b))){
    printf(":(\n");
}

if ((a == b) && (b < c)){
    printf(":)\n");
}

if ((a == b) && (b > c)){
    printf(":(\n");
}

if ((a == b) && (b == c)){
    printf(":(\n");
}
    return 0;
}