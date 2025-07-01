#include <stdio.h>

int main() {
    int Angka;
    int hasil = 0;

    scanf("%d", &Angka);
    
    while (Angka != 0) {
        if ((Angka % 10 == 2) || (Angka % 10 == 3) || (Angka % 10 == 5) || (Angka % 10 == 7)) {
            hasil = hasil*10 + (Angka % 10);
        }

        Angka /= 10;
    }

    printf("%d\n", hasil);

    return 0;
}