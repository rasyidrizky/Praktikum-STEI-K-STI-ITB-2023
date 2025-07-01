#include <stdio.h>
#include "merge.h"

List mergeSortedList(List L1, List L2) {
/*
    Membuat suatu fungsi yang mengambil 2 buah list yang berurutan dan menyatukannya
    menjadi satu buah list yang berurutan. 

    Asumsi List Input : 
    1. List input adalah List linier yang berisi integer
    2. List input mungkin kosong
    3. List input mungkin memiliki lebih dari satu elemen yang sama, misalnya [1,1]
    4. List input pasti berurutan dari kecil ke besar

    CONTOH 1
    input : 
        L1 = [1,1,2,3]
        L2 = [1,2]
    output : [1,1,1,2,2,3]

    CONTOH 2 
    input : 
        L1 = [1,3]
        l2 = [2,4]
    output : [1,2,3,4]

 */
    List L3;

    CreateEmpty(&L3);

    if (IsEmpty(L1)) {
        First(L3) = First(L2);
    } else if (IsEmpty(L2)) {
        First(L3) = First(L1);
    } else {
        List temp;
        CreateEmpty(&temp);

        Konkat1(&L1, &L2, &temp);
        
        while (!IsEmpty(temp)) {
            infotype X = Min(temp);
            InsVLast(&L3, X);
            DelP(&temp, X);
        }
    }

    CreateEmpty(&L1);
    CreateEmpty(&L2);
    return L3;
}