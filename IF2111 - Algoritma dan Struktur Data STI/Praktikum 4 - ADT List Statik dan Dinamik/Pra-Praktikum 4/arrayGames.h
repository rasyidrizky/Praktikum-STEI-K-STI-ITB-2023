#include "boolean.h"

#ifndef ARRAYGAMES_H
#define ARRAYGAMES_H

/* Kamus Umum */

#define IdxMax 100
#define IdxMin 1
#define IdxUndef -999 /* indeks tak terdefinisi*/

/* Definisi elemen dan koleksi objek */
typedef int IdxType;
typedef struct
{
    char *nama;
    int rating;
    int harga;
} ElType;

typedef struct
{
    ElType TI[IdxMax - IdxMin + 1]; /* memori tempat penyimpan elemen (container) */
    int Neff;                       /* banyaknya elemen efektif */
} TabGames;

/* Indeks yang digunakan [IdxMin..IdxMax] */
/* Jika T adalah TabGames, cara deklarasi dan akses: */
/* Deklarasi : T : TabGames */
/* Maka cara akses:
 * T.Neff untuk mengetahui banyaknya elemen
 * T.TI untuk mengakses seluruh nilai elemen tabel
 * T.TI[i] untuk mengakses elemen ke-i */
/* Definisi :
 * Tabel kosong: T.Neff = 0
 * Definisi elemen pertama : T.TI[i] dengan i=1
 * Definisi elemen terakhir yang terdefinisi: T.TI[i] dengan i=T.Neff */

/* ********** KONSTRUKTOR ARRAY ********** */
/* Konstruktor : create tabel kosong */
void MakeEmpty(TabGames *T);
/* I.S. sembarang */
/* F.S. Terbentuk tabel T kosong dengan kapasitas IdxMax-IdxMin+1 */

/* ********** SELEKTOR ********** */
/* *** Banyaknya elemen *** */
int NbElmt(TabGames T);
/* Mengirimkan banyaknya elemen efektif tabel */
/* Mengirimkan nol jika tabel kosong */

/* *** Daya tampung container *** */
int MaxNbEl(TabGames T);
/* Mengirimkan maksimum elemen yang dapat ditampung oleh tabel */
/* *** Selektor INDEKS *** */

IdxType GetFirstIdx(TabGames T);
/* Prekondisi : Tabel T tidak kosong */
/* Mengirimkan indeks elemen pertama */

IdxType GetLastIdx(TabGames T);
/* Prekondisi : Tabel T tidak kosong */
/* Mengirimkan indeks elemen terakhir */
/* *** Menghasilkan sebuah elemen *** */

ElType GetElmt(TabGames T, IdxType i);
/* Prekondisi : Tabel tidak kosong, i antara FirstIdx(T)..LastIdx(T) */
/* Mengirimkan elemen tabel yang ke-i */

/* *** Selektor SET : Mengubah nilai TABEL dan elemen tabel *** */
/* Untuk type private/limited private pada bahasa tertentu */
void SetTab(TabGames Tin, TabGames *Tout);
/* I.S. Tin terdefinisi, sembarang */
/* F.S. Tout berisi salinan Tin */
/* Assignment THsl -> Tin */

void SetEl(TabGames *T, IdxType i, ElType v);
/* I.S. T terdefinisi, sembarang */
/* F.S. Elemen T yang ke-i bernilai v */
/* Mengeset nilai elemen tabel yang ke-i sehingga bernilai v */

void SetNeff(TabGames *T, IdxType N);
/* I.S. T terdefinisi, sembarang */
/* F.S. Nilai indeks efektif T bernilai N */
/* Mengeset nilai indeks elemen efektif sehingga bernilai N */

/* ********** Test Indeks yang valid ********** */
boolean IsIdxValid(TabGames T, IdxType i);
/* Prekondisi : i sembarang */
/* Mengirimkan true jika i adalah indeks yang valid utk ukuran tabel */
/* yaitu antara indeks yang terdefinisi utk container*/

boolean IsIdxEff(TabGames T, IdxType i);
/* Prekondisi : i sembarang*/
/* Mengirimkan true jika i adalah indeks yang terdefinisi utk tabel */
/* yaitu antara FirstIdx(T)..LastIdx(T) */

/* ********** TEST KOSONG/PENUH ********** */
/* *** Test tabel kosong *** */
boolean IsEmpty(TabGames T);
/* Mengirimkan true jika tabel T kosong, mengirimkan false jika tidak */

/* *** Test tabel penuh *** */
boolean IsFull(TabGames T);
/* Mengirimkan true jika tabel T penuh, mengirimkan false jika tidak */

/* ********** BACA dan TULIS dengan INPUT/OUTPUT device ********** */
void TulisIsi(TabGames T);
/* Proses : Menuliskan isi tabel dengan traversal */
/* I.S. T boleh kosong */
/* F.S. Jika T tidak kosong : indeks dan elemen tabel ditulis berderet ke bawah */
/* Contoh print tabel
Test | 8 | 300000
Ini Juga Test | 5 | 12000
Test Lagi | 6 | 50000
*/
/* Jika T kosong : Hanya menulis "Tabel kosong" */

/* ********** KONSTRUKTOR GAMES ********** */
ElType MakeGame(char *Nama, int Rating, int Harga);
/* Membentuk sebuah Game dari komponen-komponennya */
/* I.S. Nama, Rating, Nilai terdefinisi */
/* F.S. Game G terbentuk dengan Nama, Rating, Harga yang sesuai */

/* ********** OPERATOR STATISTIK GAME ********** */
float RataRataHarga(TabGames T);
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan rata-rata harga dari elemen tabel */

float RataRataRating(TabGames T);
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan rata-rata rating dari elemen tabel */

int MaxRating(TabGames T);
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan nilai rating maksimum dari elemen tabel */

int MinRating(TabGames T);
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan nilai rating minimum dari elemen tabel */

char *MaxHargaNama(TabGames T);
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan nama game dengan harga tertinggi */
/* Jika ada lebih dari satu game dengan harga tertinggi, maka yang diambil yang memiliki rating lebih tinggi */

char *MinHargaNama(TabGames T);
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan nama game dengan harga tertinggi */
/* Jika ada lebih dari satu game dengan harga terendah, maka yang diambil yang memiliki rating lebih tinggi */

int JumlahGamesRating(TabGames T, int R);
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan jumlah game yang memiliki rating R */
/* Jika tidak ada game yang memiliki rating tersebut, maka menghasilkan 0 */

#endif