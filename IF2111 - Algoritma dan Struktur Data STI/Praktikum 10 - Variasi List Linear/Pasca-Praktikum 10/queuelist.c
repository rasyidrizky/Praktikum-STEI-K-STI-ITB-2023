#include <stdio.h>
#include "queuelist.h"
#include <stdlib.h>

/* Prototype manajemen memori */
void Alokasi(address *P, infotype X) {
/* I.S. Sembarang */
/* F.S. Alamat P dialokasi, jika berhasil maka Info(P)=X dan
        Next(P)=Nil */
/*      P=Nil jika alokasi gagal */
    *P = (Node*) malloc (sizeof(Node));
    if ((*P) != Nil) {
        Info(*P) = X;
        Next(*P) = Nil;   
    }
}

void Dealokasi(address P) {
/* I.S. P adalah hasil alokasi, P != Nil */
/* F.S. Alamat P didealokasi, dikembalikan ke sistem */
    free(P);
}

boolean IsEmpty(Queue Q) {
/* Mengirim true jika Q kosong: HEAD(Q)=Nil and TAIL(Q)=Nil */
    return (Head(Q) == Nil) && (Tail(Q) == Nil); 
}

int NbElmt(Queue Q) {
/* Mengirimkan banyaknya elemen queue. Mengirimkan 0 jika Q kosong */
    int count = 0;
    address p;

    p = Head(Q);
    if (p != Nil) {
        do {
            count++;
            p = Next(p);
        } while (p != Nil);
    }

    return count;
}

/*** Kreator ***/
void CreateEmpty(Queue *Q) {
/* I.S. sembarang */
/* F.S. Sebuah Q kosong terbentuk */
    Head(*Q) = Nil;
    Tail(*Q) = Nil;
}

/*** Primitif Add/Delete ***/
void Enqueue(Queue *Q, infotype X) {
/* Proses: Mengalokasi X dan menambahkan X pada bagian TAIL dari Q
   jika alokasi berhasil; jika alokasi gagal Q tetap */
/* Pada dasarnya adalah proses insert last */
/* I.S. Q mungkin kosong */
/* F.S. X menjadi TAIL, TAIL "maju" */
    address p;

    Alokasi(&p,X);

    if (p != Nil) {
        if (IsEmpty(*S)) {
            Head(*Q) = p;
            Tail(*Q) = p;
            Next(p) = Nil;
        } else {
            address last = Head(*Q);
            do {
                p = Next(p);
            } while (Next(last) != Nil);
            Next(last) = p;
            Last(*Q) = Next(last);
        }
    }
}

void Dequeue(Queue *Q, infotype *X) {
/* Proses: Menghapus X pada bagian HEAD dari Q dan mendealokasi
   elemen HEAD */
/* Pada dasarnya operasi delete first */
/* I.S. Q tidak mungkin kosong */
/* F.S. X = nilai elemen HEAD pd I.S., HEAD "mundur" */
    address p = Head(*Q);

    *X = Info(p);

    if (p != Nil) {
        Head(*Q) = Next(p);
        Next(p) = Nil;
        Dealokasi(p);
    }
}