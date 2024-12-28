#include <stdio.h>
#include "linkstack.h"
#include <stdlib.h>
#include "boolean.h"

/* ********* PROTOTYPE MANAJEMEN MEMORI ********* */
void Alokasi(address *P, ElType X) {
/* I.S. Sembarang */
/* F.S. Alamat P dialokasi, jika berhasil maka Info(P)=X dan Next(P)=Nil */
/* P=Nil jika alokasi gagal */
    *P = (Node*) malloc (sizeof(Node));
    Info(*P) = X;
    Next(*P) = Nil;
}

void Dealokasi(address P) {
/* I.S. P adalah hasil alokasi, P <> Nil */
/* F.S. Alamat P didealokasi, dikembalikan ke sistem */
    free(P);
}

/* ********* PROTOTYPE REPRESENTASI LOJIK STACK ***************/
boolean IsEmpty(Stack S) {
/* Mengirim true jika Stack kosong: TOP(S) = Nil */
    return Top(S) == Nil;
}

void CreateEmpty(Stack *S) {
/* I.S. sembarang */
/* F.S. Membuat sebuah stack S yang kosong */
    Top(*S) = Nil;
}

void Push(Stack *S, ElType X) {
/* Menambahkan X sebagai elemen Stack S */
/* I.S. S mungkin kosong, X terdefinisi */
/* F.S. X menjadi TOP yang baru jika alokasi X berhasil, */
/* jika tidak, S tetap */
/* Pada dasarnya adalah operasi Insert First pada list linier */
    address p;

    Alokasi(&p,X);
    if (p != Nil) {
        if (IsEmpty(*S)) {
            Top(*S) = p; 
            Next(p) = Nil;
        } else {
            Next(p) = Top(*S);
            Top(*S) = p;
        }
    }
}

void Pop(Stack *S, ElType *X) {
/* Menghapus X dari Stack S. */
/* I.S. S tidak mungkin kosong */
/* F.S. X adalah nilai elemen TOP yang lama, */
/* elemen TOP yang lama didealokasi */
/* Pada dasarnya adalah operasi Delete First pada list linier */
    address last;

    last = Top(*S);
    *X = Info(last);
    if (last != Nil) {
        Top(*S) = Next(last);
        Next(last) = Nil;
        Dealokasi(last);
    }
}