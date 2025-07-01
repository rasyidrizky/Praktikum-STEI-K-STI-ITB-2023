/* File : listlinierv2.h */
/* contoh ADT list berkait dengan representasi fisik pointer  */
/* Representasi address dengan pointer */
/* infotype adalah integer */

#ifndef listlinier_H
#define listlinier_H

#include "boolean.h"
#include <stdio.h>
#include <stdlib.h>

#define Nil NULL

typedef unsigned long long infotype;
typedef struct tElmtlist *address;
typedef struct {
    infotype prevHash;
    infotype data;
    infotype timestamp;
} BlockData;
typedef struct tElmtlist
{
    BlockData info;
    address next;
} ElmtList;
typedef struct
{
    address First;
} List;

/* Definisi list : */
/* List kosong : First(L) = Nil */
/* Setiap elemen dengan address P dapat diacu Info(P), Next(P) */
/* Elemen terakhir list : jika addressnya Last, maka Next(Last)=Nil */
#define Info(P) (P)->info
#define PrevHash(P) Info(P).prevHash
#define Data(P) Info(P).data
#define Timestamp(P) Info(P).timestamp
#define Next(P) (P)->next
#define First(L) ((L).First)

/* PROTOTYPE */
/****************** TEST LIST KOSONG ******************/
boolean IsEmpty(List L);
/* Mengirim true jika list kosong */

/****************** PEMBUATAN LIST KOSONG ******************/
void CreateEmpty(List *L);
/* I.S. sembarang             */
/* F.S. Terbentuk list kosong */

/****************** Manajemen Memori ******************/
address Alokasi(BlockData info);
/* Mengirimkan address hasil alokasi sebuah elemen */
/* Jika alokasi berhasil, maka address tidak nil, dan misalnya */
/* menghasilkan P, maka info(P)=X, Next(P)=Nil */
/* Jika alokasi gagal, mengirimkan Nil */
void Dealokasi(address *P);
/* I.S. P terdefinisi */
/* F.S. P dikembalikan ke sistem */
/* Melakukan dealokasi/pengembalian address P */

/****************** PRIMITIF BERDASARKAN NILAI ******************/
/*** PENAMBAHAN ELEMEN ***/
void InsVLast(List *L, infotype prevHash, infotype data, infotype timestamp);
/* I.S. L mungkin kosong */
/* F.S. Melakukan alokasi sebuah elemen dan */
/* menambahkan elemen list di akhir: elemen terakhir yang baru */
/* berupa BlockData berisi prevHash, data, dan timestamp jika alokasi berhasil. Jika alokasi gagal: I.S.= F.S. */

/****************** PRIMITIF BERDASARKAN ALAMAT ******************/
/*** PENAMBAHAN ELEMEN BERDASARKAN ALAMAT ***/
void InsertLast(List *L, address P);
/* I.S. Sembarang, P sudah dialokasi  */
/* F.S. P ditambahkan sebagai elemen terakhir yang baru */

/****************** PROSES SEMUA ELEMEN LIST ******************/
int NbElmt(List L);
/* Mengirimkan banyaknya elemen list; mengirimkan 0 jika list kosong */

#endif