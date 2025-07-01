#include <stdio.h>

int main() {
    char nama[21];

    scanf("%20s", nama);

    if ((nama[0] == 'A') || (nama[0] == 'I') || (nama[0] == 'U') || (nama[0] == 'E') || (nama[0] == 'O') || (nama[0] == 'a') || (nama[0] == 'i') || (nama[0] == 'u') || (nama[0] == 'e') || (nama[0] == 'o')) {
        printf("%s menjawab: \"Bintang skibidi, bintang yang paling skibidi tertinggi itu kecuali skibidi 5 hanyalah mewing besar\"\n", nama);
    } else { printf("%s menjawab: \"Bintang skibidi. Matahari terbenam di balik skibidi, hanya skibidi 7 yang tahu apa artinya\"\n", nama); }

    return 0;
}