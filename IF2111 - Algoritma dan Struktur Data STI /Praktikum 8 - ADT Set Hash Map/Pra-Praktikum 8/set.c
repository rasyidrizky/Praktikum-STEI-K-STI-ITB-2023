#include <stdio.h>
#include "set.h"

/* *** Konstruktor/Kreator *** */
void CreateEmpty(Set *S) {
/* I.S. Sembarang */
/* F.S. Membuat sebuah Set S kosong berkapasitas MaxEl */
/* Ciri Set kosong : count bernilai Nil */
    (*S).Count = Nil;
}

/* ********* Predikat Untuk test keadaan KOLEKSI ********* */
boolean IsEmpty(Set S) {
/* Mengirim true jika Set S kosong*/
/* Ciri Set kosong : count bernilai Nil */
    return S.Count == 0; 
}

boolean IsFull(Set S) {
/* Mengirim true jika Set S penuh */
/* Ciri Set penuh : count bernilai MaxEl */
    return S.Count == MaxEl;
}

/* ********** Operator Dasar Set ********* */
void Insert(Set *S, infotype Elmt) {
/* Menambahkan Elmt sebagai elemen Set S. */
/* I.S. S mungkin kosong, S tidak penuh
        S mungkin sudah beranggotakan Elmt */
/* F.S. Elmt menjadi anggota dari S. Jika Elmt sudah merupakan anggota, operasi tidak dilakukan */
    int i = 0;
    boolean found = false;

    while (i < (*S).Count && !found) {
        if ((*S).Elements[i] == Elmt) {
            found = true;
        }
        i++;
    }

    if (!found) {
        (*S).Elements[i] = Elmt;
        (*S).Count++;
    }

}

void Delete(Set *S, infotype Elmt) {
/* Menghapus Elmt dari Set S. */
/* I.S. S tidak kosong
        Elmt mungkin anggota / bukan anggota dari S */
/* F.S. Elmt bukan anggota dari S */
    int i = 0, j;
    boolean delete = false;

    while (i < (*S).Count && !delete) {
        if ((*S).Elements[i] == Elmt) {
            delete = true;
        } else {
            i++;
        }
    }

    for (j = i; j < (*S).Count; j++) {
        (*S).Elements[j] = (*S).Elements[j+1];
    }
    (*S).Count--;

}

boolean IsMember(Set S, infotype Elmt) {
/* Mengembalikan true jika Elmt adalah member dari S */
    int i = 0;
    boolean found = false;

    while (i < S.Count && !found) {
        if (S.Elements[i] ==  Elmt) {
            found = true;
        } else {
            i++;
        }
    }

    return found;
}