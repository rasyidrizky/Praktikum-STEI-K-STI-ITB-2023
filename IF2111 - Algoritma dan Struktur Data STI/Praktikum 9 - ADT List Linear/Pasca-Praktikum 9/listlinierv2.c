/* File : listlinierv2.c */
/* contoh ADT list berkait dengan representasi fisik pointer  */
/* Representasi address dengan pointer */
/* infotype adalah integer */

#include <stdio.h>
#include <stdlib.h>
#include "listlinierv2.h"

/* PROTOTYPE */
/****************** TEST LIST KOSONG ******************/
boolean IsEmpty(List L)
/* Mengirim true jika list kosong */
{
    return First(L) == Nil;
}

/****************** PEMBUATAN LIST KOSONG ******************/
void CreateEmpty(List *L)
/* I.S. sembarang             */
/* F.S. Terbentuk list kosong */
{
    First(*L) = Nil;
}

/****************** Manajemen Memori ******************/
address Alokasi(BlockData info)
/* Mengirimkan address hasil alokasi sebuah elemen */
/* Jika alokasi berhasil, maka address tidak nil, dan misalnya */
/* menghasilkan P, maka Info(P)=info, Next(P)=Nil */
/* Jika alokasi gagal, mengirimkan Nil */
{
    address P = (address)malloc(1 * sizeof(ElmtList));
    if (P != Nil)
    {
        Info(P) = info;
        Next(P) = Nil;
        return P;
    }
    {
        return Nil;
    }
}

void Dealokasi(address *P)
/* I.S. P terdefinisi */
/* F.S. P dikembalikan ke sistem */
/* Melakukan dealokasi/pengembalian address P */
{
    free(*P);
}

/****************** PRIMITIF BERDASARKAN NILAI ******************/
/*** PENAMBAHAN ELEMEN ***/
void InsVLast(List *L, infotype prevHash, infotype data, infotype timestamp)
/* I.S. L mungkin kosong */
/* F.S. Melakukan alokasi sebuah elemen dan */
/* menambahkan elemen list di akhir: elemen terakhir yang baru */
/* berupa BlockData berisi prevHash, data, dan timestamp jika alokasi berhasil. Jika alokasi gagal: I.S.= F.S. */
{
    BlockData newBlock;
    newBlock.prevHash = prevHash;
    newBlock.data = data;
    newBlock.timestamp = timestamp;
    address P = Alokasi(newBlock);
    if (P != Nil)
    {
        InsertLast(L, P);
    }
}

/****************** PRIMITIF BERDASARKAN ALAMAT ******************/
/*** PENAMBAHAN ELEMEN BERDASARKAN ALAMAT ***/
void InsertLast(List *L, address P)
/* I.S. Sembarang, P sudah dialokasi  */
/* F.S. P ditambahkan sebagai elemen terakhir yang baru */
{
    address Last;

    if (IsEmpty(*L))
    {
        Next(P) = First(*L);
        First(*L) = P;
    }
    else
    {
        Last = First(*L);
        while (Next(Last) != Nil)
        {
            Last = Next(Last);
        }
        Next(P) = Next(Last);
        Next(Last) = P;
    }
}

int NbElmt(List L)
/* Mengirimkan banyaknya elemen list; mengirimkan 0 jika list kosong */
{
    int cnt = 0;
    address P;

    if (!IsEmpty(L))
    {
        P = First(L);
        while (P != Nil)
        {
            cnt++;
            P = Next(P);
        }
    }

    return cnt;
}