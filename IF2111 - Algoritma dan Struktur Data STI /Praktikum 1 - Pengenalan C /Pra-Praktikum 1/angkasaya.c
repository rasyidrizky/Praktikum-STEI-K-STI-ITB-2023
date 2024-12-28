#include <stdio.h>

int main() {
    int Angka;
    int Count = 1;
    int SumFir = 0;
    int SumSec = 0;

    scanf("%d",&Angka);

    while (Angka != 0) {
        if (Count % 2 == 0) {
            SumSec = SumSec + (Angka % 10);
        } else {
            SumFir = SumFir + (Angka % 10);
        }
        Angka /= 10;
        Count++;
    }

    if (Count % 2 == 0) {
        printf("%d\n", SumSec);
    } else { printf("%d\n", SumFir); }

    return 0;
}