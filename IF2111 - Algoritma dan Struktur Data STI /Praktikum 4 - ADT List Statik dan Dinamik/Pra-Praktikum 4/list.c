#include <stdio.h>
#include "boolean.h"
#include "list.h"

/* ********** KONSTRUKTOR ********** */
/* Konstruktor: create list kosong */
List MakeList() {
/* I.S. sembarang */
/* F.S. Terbentuk list L kosong dengan kapasitas MaxEl */
    List L;

    for (int i = 0; i < MaxEl; i++) {
        L.A[i] = Mark;
    }

    return L;
}

/* ********** TEST KOSONG/PENUH ********** */
/* *** Test list kosong *** */
boolean IsEmpty(List L) {
/* Mengirimkan true jika list L kosong, mengirimkan false jika tidak */
    return L.A[0] == Mark;
}

/* *** Menghasilkan sebuah elemen *** */
ElType Get(List L, IdxType i) {
/* Prekondisi : list tidak kosong, i antara FirstIdx(T)..LastIdx(T) */
/* Mengirimkan elemen list yang ke-i */
    return L.A[i];
}

/* *** Selektor SET : Mengubah nilai list dan elemen list *** */
void Set(List *L, IdxType i, ElType v) {
/* I.S. T terdefinisi, sembarang */
/* F.S. Elemen T yang ke-i bernilai v */
    (*L).A[i] = v;
}

/* ********** SELEKTOR ********** */
/* *** Banyaknya elemen *** */
int Length(List L) {
/* Mengirimkan banyaknya elemen efektif list */
/* Mengirimkan nol jika list kosong */
    int length = 0;
    IdxType i;

    if (IsEmpty(L)) {
        return length;
    } else {
        for (i = 0; i < MaxEl; i++) {
            if (Get(L, i) != Mark) {
                length++;
            }
        }
        return length;
    }
}

/* *** Selektor INDEKS *** */
IdxType FirstIdx(List L) {
/* Prekondisi : list L tidak kosong */
/* Mengirimkan indeks elemen pertama */
    return 0;
}

IdxType LastIdx(List L) {
/* Prekondisi : list L tidak kosong */
/* Mengirimkan indeks elemen terakhir */
    return (Length(L) - 1);
}

/* ********** Test Indeks yang valid ********** */
boolean IsIdxValid (List L, IdxType i) {
/* Prekondisi : i sembarang */
/* Mengirimkan true jika i adalah indeks yang valid utk ukuran list */
/* yaitu antara indeks yang terdefinisi untuk container*/
    return ((i >= 0) && (i <= (MaxEl - 1)));
}

boolean IsIdxEff (List L, IdxType i) {
/* Prekondisi : i sembarang*/
/* Mengirimkan true jika i adalah indeks yang terdefinisi utk list */
/* yaitu antara FirstIdx(L)..LastIdx(L) */
    return ((i >= FirstIdx(L)) && (i <= LastIdx(L)));
}

/* ********** Operasi-operasi ********** */
boolean Search(List L, ElType X) {
/* Prekondisi : X sembarang */
/* Mengirimkan true jika terdapat elemen X di dalam list */
/* yaitu antara FirstIdx(L)..LastIdx(L) */
    IdxType i;

    for (i = FirstIdx(L); i <= LastIdx(L); i++) {
        if (Get(L,i) == X) {
            return 1;
        }
    }
    return 0;
}

void InsertFirst(List *L, ElType X) {
/* I.S. L terdefinisi, mungkin kosong. */
/* F.S. v menjadi elemen pertama L. */
    IdxType i;
    
    if (IsEmpty(*L)) {
        Set(L,FirstIdx(*L),X);
    } else {
        for (i = LastIdx(*L); i >= FirstIdx(*L); i--) {
            Set(L,i + 1,Get(*L, i));
        }
        Set(L,FirstIdx(*L),X);
    }
}

void InsertAt(List *L, ElType X, IdxType i) {
/* I.S. L terdefinisi, tidak kosong, i merupakan indeks lojik yang valid di L. */
/* F.S. v disisipkan dalam L pada indeks ke-i (bukan menimpa elemen di i). */
    IdxType j;
    
    for (j = LastIdx(*L); j >= i; j--) {
        Set(L,j + 1,Get(*L, j));
    }
    Set(L,i,X);
}

void InsertLast(List *L, ElType X) {
/* I.S. L terdefinisi, mungkin kosong. */
/* F.S. v menjadi elemen terakhir L. */
    if (IsEmpty(*L)) {
        Set(L,FirstIdx(*L),X);
    } else {
    Set(L,LastIdx(*L)+1,X);
    }
}

void DeleteFirst(List *L) {
/* I.S. L terdefinisi, tidak kosong. */
/* F.S. F diset dengan elemen pertama L, elemen pertama L dihapus dari L. */
    IdxType i;

    for (i = FirstIdx(*L); i < LastIdx(*L); i++) {
        Set(L,i,Get(*L,i+1));
    }
    Set(L,LastIdx(*L),Mark);
}

void DeleteAt(List *L, IdxType i) {
/* I.S. L terdefinisi, tidak kosong, i merupakan indeks lojik yang valid di L. */
/* F.S. Elemen L pada indeks ke-i dihapus dari L. */
    IdxType j, k;

    for (j = 0; j < MaxEl; j++) {
        if (j == i) {
            for (k = j; k < LastIdx(*L); k++) {
                Set(L,k,Get(*L,k+1));
            }
        }
    }
    Set(L,LastIdx(*L),Mark);
}

void DeleteLast(List *L) {
/* I.S. L terdefinisi, tidak kosong. */
/* F.S. F diset dengan elemen terakhir L, elemen terakhir L dihapus dari L. */
    Set(L,LastIdx(*L),Mark);
}

List Concat(List L1, List L2) {
/* Prekondisi : L1 dan L2 tidak kosong */
/* Mengirimkan sebuah List yang merupakan gabungan dari L1 dan L2 */
/* Urutan elemen terisi dari L1, lalu L2 */
/* Contoh : L1 : [1, 2]; L2 : [3, 4]; Mengembalikan [1, 2, 3, 4] */
    List L = MakeList();
    IdxType i, idx = 0;

    for (i = FirstIdx(L1); i <= LastIdx(L1); i++) {
        Set(&L,idx,Get(L1,i));
        idx++;
    }
    for (i = FirstIdx(L2); i <= LastIdx(L2); i++) {
        Set(&L,idx,Get(L2,i));
        idx++;
    }

    return L;
}