#include <stdio.h>

int main() {
    char kata1[101];
    char kata2[101];
    int i = 0;
    int hasil = 1;


    scanf("%100s\0", kata1);
    scanf("%100s\0", kata2);

    while ( kata1[i] != '\0' ) {
        if ((kata1[i] != kata2[i]) && (kata1[i] != '*')) {
            hasil = 0;
            printf("%d\n", hasil);
        }
        i++;
    }
    if (hasil == 1) {
        printf("%d\n", hasil);
    }
    return 0;
}