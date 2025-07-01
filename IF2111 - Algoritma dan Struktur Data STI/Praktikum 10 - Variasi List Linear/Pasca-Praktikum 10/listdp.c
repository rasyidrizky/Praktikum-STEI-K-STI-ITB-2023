#include <stdio.h>
#include <stdlib.h>
#include "listdp.h"

/* PROTOTYPE */
/****************** TEST LIST KOSONG ******************/
boolean IsEmpty (List L) {
/* Mengirim true jika list kosong. Lihat definisi di atas. */
    return (First(L) == Nil && Last(L) == Nil);
}

/****************** PEMBUATAN LIST KOSONG ******************/
void CreateEmpty (List *L) {
/* I.S. L sembarang  */
/* F.S. Terbentuk list kosong. Lihat definisi di atas. */
    First(*L) = Nil;
    Last(*L) = Nil;
}

/****************** Manajemen Memori ******************/
address Alokasi (infotype X) {
/* Mengirimkan address hasil alokasi sebuah elemen */
/* Jika alokasi berhasil, maka address tidak nil. */
/* Misalnya: menghasilkan P, maka Info(P)=X, Next(P)=Nil, Prev(P)=Nil */
/* Jika alokasi gagal, mengirimkan Nil. */
    address P = (address) malloc(sizeof(ElmtList));
    if (P != Nil){
        Info(P) = X;
        Next(P) = Nil;
        Prev(P) = Nil;
    }
    return P;
}
void Dealokasi (address P) {
/* I.S. P terdefinisi */
/* F.S. P dikembalikan ke sistem */
/* Melakukan dealokasi/pengembalian address P */
    free(P);
}

/****************** PENCARIAN SEBUAH ELEMEN LIST ******************/
address Search (List L, infotype X) {
/* Mencari apakah ada elemen list dengan Info(P)=X */
/* Jika ada, mengirimkan address elemen tersebut. */
/* Jika tidak ada, mengirimkan Nil */
    address P = First(L);
    while (P != Nil && Info(P) != X){
        P = Next(P);
    }
    return P;
}

/****************** PRIMITIF BERDASARKAN NILAI ******************/
/*** PENAMBAHAN ELEMEN ***/
void InsVFirst (List *L, infotype X) {
/* I.S. L mungkin kosong */
/* F.S. Melakukan alokasi sebuah elemen dan */
/* menambahkan elemen pertama dengan nilai X jika alokasi berhasil */
    address P = Alokasi(X);
    if (P != Nil){
        Next(P) = First(*L);
        if (!IsEmpty(*L)) {
            Prev(First(*L)) = P;
        } else {
            Last(*L) = P;
        }
        First(*L) = P;
    }
}
void InsVLast (List *L, infotype X) {
/* I.S. L mungkin kosong */
/* F.S. Melakukan alokasi sebuah elemen dan */
/* menambahkan elemen list di akhir: elemen terakhir yang baru */
/* bernilai X jika alokasi berhasil. Jika alokasi gagal: I.S.= F.S. */
    address P = Alokasi(X);
    if (P != Nil) {
        Prev(P) = Last(*L);
        if (!IsEmpty(*L)) {
            Next(Last(*L)) = P;
        } else {
            First(*L) = P;
        }
        Last(*L) = P;
    }
}

/*** PENGHAPUSAN ELEMEN ***/
void DelVFirst (List *L, infotype *X) {
/* I.S. List L tidak kosong  */
/* F.S. Elemen pertama list dihapus: nilai info disimpan pada X */
/*      dan alamat elemen pertama di-dealokasi */
    address P = First(*L);
    *X = Info(P);
    if (First(*L) == Last(*L)) {
        Last(*L) = Nil;
    } else {
        Prev(Next(First(*L))) = Nil;
    }
    First(*L) = Next(First(*L));
    free(P);
}

void DelVLast (List *L, infotype *X) {
/* I.S. list tidak kosong */
/* F.S. Elemen terakhir list dihapus: nilai info disimpan pada X */
/*      dan alamat elemen terakhir di-dealokasi */
    address P = Last(*L);
    *X = Info(P);
    if (First(*L) == Last(*L)) {
        First(*L) = Nil;
    } else {
        Next(Prev(Last(*L))) = Nil;
    }
    Last(*L) = Prev(Last(*L));
    free(P);
}

/****************** PRIMITIF BERDASARKAN ALAMAT ******************/
/*** PENAMBAHAN ELEMEN BERDASARKAN ALAMAT ***/
void InsertFirst (List *L, address P) {
/* I.S. Sembarang, P sudah dialokasi  */
/* F.S. Menambahkan elemen ber-address P sebagai elemen pertama */
    Next(P) = First(*L);
    if (!IsEmpty(*L)) {
        Prev(First(*L)) = P;
    } else {
        Last(*L) = P;
    }
    First(*L) = P;
}
void InsertLast (List *L, address P) {
/* I.S. Sembarang, P sudah dialokasi  */
/* F.S. P ditambahkan sebagai elemen terakhir yang baru */
    Prev(P) = Last(*L);
    if (!IsEmpty(*L)) {
        Next(Last(*L)) = P;
    } else {
        First(*L) = P;
    }
    Last(*L) = P;
}
void InsertAfter (List *L, address P, address Prec) {
/* I.S. Prec pastilah elemen list; P sudah dialokasi  */
/* F.S. Insert P sebagai elemen sesudah elemen beralamat Prec */
    if (Prec == Last(*L)) {
        Next(P) = Next(Prec);
        Prev(Next(Prec)) = P;
        Next(Prec) = P;
        Prev(P) = Prec;
    } else {
        InsertLast(L,P);
    }
}

void InsertBefore (List *L, address P, address Succ) {
/* I.S. Succ pastilah elemen list; P sudah dialokasi  */
/* F.S. Insert P sebagai elemen sebelum elemen beralamat Succ */
    if (Prev(Succ) != Nil) {
        Prev(P) = Prev(Succ);
        Next(Prev(Succ)) = P;
        Prev(Succ) = P;
        Next(P) = Succ;
    } else {
        InsertFirst(L,P);
    }
}

/*** PENGHAPUSAN SEBUAH ELEMEN ***/
void DelFirst (List *L, address *P) {
/* I.S. List tidak kosong */
/* F.S. P adalah alamat elemen pertama list sebelum penghapusan */
/*      Elemen list berkurang satu (mungkin menjadi kosong) */
/* First element yg baru adalah suksesor elemen pertama yang lama */
    *P = First(*L);
    if (First(*L) == Last(*L)) {
        First(*L) = Nil;
        Last(*L) = Nil;
    } else {
        First(*L) = Next(First(*L));
        Prev(First(*L)) = Nil;
        Next(*P) = Nil;
        Prev(*P) = Nil;
    }
}

void DelLast (List *L, address *P) {
/* I.S. List tidak kosong */
/* F.S. P adalah alamat elemen terakhir list sebelum penghapusan  */
/*      Elemen list berkurang satu (mungkin menjadi kosong) */
/* Last element baru adalah predesesor elemen pertama yg lama, jika ada */
    *P = Last(*L);
    if (First(*L) == Last(*L)) {
        First(*L) = Nil;
        Last(*L) = Nil;
    } else {
        Last(*L) = Prev(Last(*L));
        Next(Last(*L)) = Nil;
        Next(*P) = Nil;
        Prev(*P) = Nil;
    }
}

void DelP (List *L, infotype X) {
/* I.S. Sembarang */
/* F.S. Jika ada elemen list beraddress P, dengan Info(P)=X  */
/* maka P dihapus dari list dan didealokasi */
/* Jika tidak ada elemen list dengan Info(P)=X, maka list tetap */
/* List mungkin menjadi kosong karena penghapusan */
    address P;
    boolean found = false;

    P = First(*L);
    while (!found && P != Nil) {
        if (Info(P) == X) {
            found = true;
        } else {
            P = Next(P);
        }
    }

    if (found) {
        if (P == First(*L)) {
            DelFirst(L,&P);
        } else if (P == Last(*L)) {
            DelLast(L,&P);
        } else {
            Next(Prev(P)) = Next(P);
            Prev(Next(P)) = Prev(P);
        }
    }
    Dealokasi(P);
}

void DelAfter (List *L, address *Pdel, address Prec) {
/* I.S. List tidak kosong. Prec adalah anggota list. */
/* F.S. Menghapus Next(Prec): */
/*      Pdel adalah alamat elemen list yang dihapus  */
    *Pdel = Next(Prec);
    Next(Prec) = Next(*Pdel);
    Prev(Next(*Pdel)) = Prec;
    Next(*Pdel) = Nil;
    Prev(*Pdel) = Nil;
}
void DelBefore (List *L, address *Pdel, address Succ) {
/* I.S. List tidak kosong. Succ adalah anggota list. */
/* F.S. Menghapus Prev(Succ): */
/*      Pdel adalah alamat elemen list yang dihapus  */
    *Pdel = Prev(Succ);
    Next(Prev(*Pdel)) = Succ;
    Prev(Succ) = Prev(*Pdel);
    Next(*Pdel) = Nil;
    Prev(*Pdel) = Nil;
}

/****************** PROSES SEMUA ELEMEN LIST ******************/
void PrintForward (List L) {
/* I.S. List mungkin kosong */
/* F.S. Jika list tidak kosong, isi list dicetak dari elemen pertama */
/* ke elemen terakhir secara horizontal ke kanan: [e1,e2,...,en] */
/* Contoh : jika ada tiga elemen bernilai 1, 20, 30 akan dicetak: [1,20,30] */
/* Jika list kosong : menulis [] */
/* Tidak ada tambahan karakter apa pun di awal, akhir, atau di tengah */
/* Terdapat newline di akhir setelah tutup kurung */
    address P = First(L);

    printf("[");
    while (P != Nil) {
        printf("%d", Info(P));
        if (P != Last(L)) {
            printf(",");
        }
        P = Next(P);
    }
    printf("]\n");
}

void PrintBackward (List L) {
/* I.S. List mungkin kosong */
/* F.S. Jika list tidak kosong, isi list dicetak dari elemen terakhir */
/* ke elemen pertama secara horizontal ke kanan: [en,en-1,...,e2,e1] */
/* Contoh : jika ada tiga elemen bernilai 1, 20, 30 akan dicetak: [30,20,1] */
/* Jika list kosong : menulis [] */
/* Tidak ada tambahan karakter apa pun di awal, akhir, atau di tengah */
/* Terdapat newline di akhir setelah tutup kurung */
    address P = Last(L);

    printf("[");
    while (P != Nil) {
        printf("%d", Info(P));
        if (P != First(L)) {
            printf(",");
        }
        P = Prev(P);
    }
    printf("]\n");
}