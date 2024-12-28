#include <stdio.h>
#include "OddEvenList.h"

void OddEvenList(List L, List *Odd, List *Even) {
    /* Memisahkan elemen ganjil dan genap dari list L kedalam dua list baru secara mengurut membesar*/
    /* I.S: List L TIDAK mungkin kosong dan memiliki nilai lebih dari sama dengan 0(value>=0), List Odd dan Even kosong*/
    /* F.S: List Odd memiliki elemen bernilai ganjil mengurut membesar, List Even memiliki elemen bernilai genap mengurut membesar
            List L TIDAK PERLU DIDEALOKASI*/
    /*Contoh:
        Input:
            L: [0,3,1,4,5]
            Odd: []
            Even: []
        Output:
            L: [0,3,1,4,5]
            Odd: [1,3,5]
            Even: [0,4] */
    /*Note: 
        1. Bilangan 0 merupakan bilangan genap
        2. Buatlah List Odd dan Even terlebih dahulu*/
    // KAMUS
    List Copy;
    int min;
    address last, p;
    
    // ALGORITMA
    CreateEmpty(&Copy);
    CreateEmpty(Odd);
    CreateEmpty(Even);

    last = First(L);
    while (last != Nil) {
        p = Alokasi(Info(last));
        InsertLast(&Copy, p);
        last = Next(last);
    }

    while (!IsEmpty(Copy)) {
        min = Min(Copy);
        DelP(&Copy, min);
        if ((min % 2) == 0) {
            InsVLast(Even, min);
        } else {
            InsVLast(Odd, min);
        }
    }
}