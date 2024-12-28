#include <stdio.h>

int main() {
    char nama[20];
    int i = 0, j = 0;

    scanf("%s", nama);

    while (nama[i] != '.') {
        i++;
    }

    while (nama[j] != '.') {
        if ((nama[j] + i) > 'Z') {
            nama[j] = ((nama[j] + i) % 'Z') + 'A' - 1;
        } else {
            nama[j] = nama[j] + i;
        }
        printf("%c", nama[j]);
        j++;
    }

    printf("\n");

    return 0;
}