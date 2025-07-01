#include <stdio.h>
#include "listlinier.h"

int main() {
    // KAMUS
    List DafNilai, InversNilai;
    infotype grade = 0;
    boolean valid = true;

    // ALGORITMA
    CreateEmpty(&DafNilai);
    CreateEmpty(&InversNilai);
    while (valid) {
        scanf("%d", &grade);
        if (grade >= 0 && grade <= 100) {
            InsVFirst(&DafNilai, grade);
            InsVFirst(&InversNilai, grade);
        } else {
            valid = false;
        }
    }

    if (IsEmpty(DafNilai)) {
        printf("Daftar nilai kosong\n");
    } else {
        printf("%d\n", NbElmt(DafNilai));
        printf("%d\n", Max(DafNilai));
        printf("%d\n", Min(DafNilai));
        printf("%.2f\n", Average(DafNilai));
        InversList(&InversNilai);
        PrintInfo(InversNilai);
        printf("\n");
        PrintInfo(DafNilai);
        printf("\n");
    }

    return 0;
}