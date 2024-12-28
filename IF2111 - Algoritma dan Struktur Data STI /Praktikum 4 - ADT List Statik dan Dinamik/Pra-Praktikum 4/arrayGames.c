#include <stdio.h>
#include "boolean.h"
#include "arrayGames.h"
#include "string.h"
#include "stdlib.h"

/* ********** KONSTRUKTOR ARRAY ********** */
/* Konstruktor : create tabel kosong */
void MakeEmpty(TabGames *T) {
/* I.S. sembarang */
/* F.S. Terbentuk tabel T kosong dengan kapasitas IdxMax-IdxMin+1 */
    (*T).Neff = 0;
}

/* ********** SELEKTOR ********** */
/* *** Banyaknya elemen *** */
int NbElmt(TabGames T) {
/* Mengirimkan banyaknya elemen efektif tabel */
/* Mengirimkan nol jika tabel kosong */
    return T.Neff;
}

/* *** Daya tampung container *** */
int MaxNbEl(TabGames T) {
/* Mengirimkan maksimum elemen yang dapat ditampung oleh tabel */
/* *** Selektor INDEKS *** */
    return IdxMax - IdxMin + 1;
}

IdxType GetFirstIdx(TabGames T) {
/* Prekondisi : Tabel T tidak kosong */
/* Mengirimkan indeks elemen pertama */
    return IdxMin;
}

IdxType GetLastIdx(TabGames T) {
/* Prekondisi : Tabel T tidak kosong */
/* Mengirimkan indeks elemen terakhir */
/* *** Menghasilkan sebuah elemen *** */
    return NbElmt(T);
}

ElType GetElmt(TabGames T, IdxType i) {
/* Prekondisi : Tabel tidak kosong, i antara FirstIdx(T)..LastIdx(T) */
/* Mengirimkan elemen tabel yang ke-i */
    return T.TI[i-IdxMin];
}

/* *** Selektor SET : Mengubah nilai TABEL dan elemen tabel *** */
/* Untuk type private/limited private pada bahasa tertentu */
void SetTab(TabGames Tin, TabGames *Tout) {
/* I.S. Tin terdefinisi, sembarang */
/* F.S. Tout berisi salinan Tin */
/* Assignment THsl -> Tin */
    *Tout = Tin;
}

void SetEl(TabGames *T, IdxType i, ElType v) {
/* I.S. T terdefinisi, sembarang */
/* F.S. Elemen T yang ke-i bernilai v */
/* Mengeset nilai elemen tabel yang ke-i sehingga bernilai v */
    (*T).TI[i - IdxMin] = v;
    if (i > (*T).Neff) {
        (*T).Neff = i;
    }
}

void SetNeff(TabGames *T, IdxType N) {
/* I.S. T terdefinisi, sembarang */
/* F.S. Nilai indeks efektif T bernilai N */
/* Mengeset nilai indeks elemen efektif sehingga bernilai N */
    (*T).Neff = N;
}

/* ********** Test Indeks yang valid ********** */
boolean IsIdxValid(TabGames T, IdxType i) {
/* Prekondisi : i sembarang */
/* Mengirimkan true jika i adalah indeks yang valid utk ukuran tabel */
/* yaitu antara indeks yang terdefinisi utk container*/
    return ((i >= IdxMin) && (i <= IdxMax));
}

boolean IsIdxEff(TabGames T, IdxType i) {
/* Prekondisi : i sembarang*/
/* Mengirimkan true jika i adalah indeks yang terdefinisi utk tabel */
/* yaitu antara FirstIdx(T)..LastIdx(T) */
    return ((i >= GetFirstIdx(T)) && (i <= GetLastIdx(T)));
}

/* ********** TEST KOSONG/PENUH ********** */
/* *** Test tabel kosong *** */
boolean IsEmpty(TabGames T) {
/* Mengirimkan true jika tabel T kosong, mengirimkan false jika tidak */
    return (T.Neff == 0);
}

/* *** Test tabel penuh *** */
boolean IsFull(TabGames T) {
/* Mengirimkan true jika tabel T penuh, mengirimkan false jika tidak */
    return (NbElmt(T) == MaxNbEl(T));
}

/* ********** BACA dan TULIS dengan INPUT/OUTPUT device ********** */
void TulisIsi(TabGames T) {
/* Proses : Menuliskan isi tabel dengan traversal */
/* I.S. T boleh kosong */
/* F.S. Jika T tidak kosong : indeks dan elemen tabel ditulis berderet ke bawah */
/* Contoh print tabel
Test | 8 | 300000
Ini Juga Test | 5 | 12000
Test Lagi | 6 | 50000
*/
/* Jika T kosong : Hanya menulis "Tabel kosong" */
    IdxType i;

    if (IsEmpty(T)) {
        printf("Tabel kosong\n");
    } else {
        for (i = GetFirstIdx(T); i <= GetLastIdx(T); i++) {
            printf("%s | %d | %d\n", GetElmt(T,i).nama, GetElmt(T,i).rating, GetElmt(T,i).harga);
        }   
    }
}

/* ********** KONSTRUKTOR GAMES ********** */
ElType MakeGame(char *Nama, int Rating, int Harga) {
/* Membentuk sebuah Game dari komponen-komponennya */
/* I.S. Nama, Rating, Nilai terdefinisi */
/* F.S. Game G terbentuk dengan Nama, Rating, Harga yang sesuai */
    ElType TI;

    TI.nama = (char *) malloc (strlen(Nama)+1);
    strcpy(TI.nama, Nama);
    TI.rating = Rating;
    TI.harga = Harga;
    
    return TI;
}

/* ********** OPERATOR STATISTIK GAME ********** */
float RataRataHarga(TabGames T) {
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan rata-rata harga dari elemen tabel */
    IdxType i;
    float result = 0;
    float count = 0;

    for (i = GetFirstIdx(T); i <= GetLastIdx(T); i++) {
        result = result + GetElmt(T,i).harga;
        count++;
    }
    return (result/count);
}

float RataRataRating(TabGames T) {
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan rata-rata rating dari elemen tabel */
    IdxType i;
    float result = 0;
    float count = 0;

    for (i = GetFirstIdx(T); i <= GetLastIdx(T); i++) {
        result = result + GetElmt(T,i).rating;
        count++;
    }
    return (result/count);
}

int MaxRating(TabGames T) {
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan nilai rating maksimum dari elemen tabel */
    int max = GetElmt(T,GetFirstIdx(T)).rating;
    IdxType i;

    for (i = GetFirstIdx(T)+1; i <= GetLastIdx(T); i++) {
        if (GetElmt(T,i).rating > max) {
            max = GetElmt(T,i).rating;
        }
    }

    return max;
}

int MinRating(TabGames T) {
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan nilai rating minimum dari elemen tabel */
    int min = GetElmt(T,GetFirstIdx(T)).rating;
    IdxType i;

    for (i = GetFirstIdx(T)+1; i <= GetLastIdx(T); i++) {
        if (GetElmt(T,i).rating < min) {
            min = GetElmt(T,i).rating;
        }
    }

    return min;
}

char *MaxHargaNama(TabGames T) {
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan nama game dengan harga tertinggi */
/* Jika ada lebih dari satu game dengan harga tertinggi, maka yang diambil yang memiliki rating lebih tinggi */
    IdxType Id = GetFirstIdx(T);
    int HargaMax = GetElmt(T,Id).harga;
    int RatingMax = GetElmt(T,Id).rating;
    IdxType i;

    for (i = GetFirstIdx(T)+1; i <= GetLastIdx(T); i++) {
        if (GetElmt(T,i).harga > HargaMax) {
            HargaMax = GetElmt(T,i).harga;
            Id = i;
            RatingMax = GetElmt(T,i).rating;
        } else if ((GetElmt(T,i).harga == HargaMax) && (GetElmt(T,i).rating > RatingMax)) {
            Id = i;
            RatingMax = GetElmt(T,i).rating;
        }
    }

    return GetElmt(T,Id).nama;
}

char *MinHargaNama(TabGames T) {
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan nama game dengan harga terendah */
/* Jika ada lebih dari satu game dengan harga terendah, maka yang diambil yang memiliki rating lebih tinggi */
    IdxType Id = GetFirstIdx(T);
    int HargaMin = GetElmt(T,Id).harga;
    int RatingMin = GetElmt(T,Id).rating;
    IdxType i;

    for (i = GetFirstIdx(T)+1; i <= GetLastIdx(T); i++) {
        if (GetElmt(T,i).harga < HargaMin) {
            HargaMin = GetElmt(T,i).harga;
            Id = i;
            RatingMin = GetElmt(T,i).rating;
        } else if ((GetElmt(T,i).harga == HargaMin) && (GetElmt(T,i).rating > RatingMin)) {
            Id = i;
            RatingMin = GetElmt(T,i).rating;
        }
    }

    return GetElmt(T,Id).nama;
}

int JumlahGamesRating(TabGames T, int R) {
/* I.S. Tabel T tidak kosong */
/* F.S. Menghasilkan jumlah game yang memiliki rating R */
/* Jika tidak ada game yang memiliki rating tersebut, maka menghasilkan 0 */
    IdxType i;
    int count = 0;

    for (i = GetFirstIdx(T); i <= GetLastIdx(T); i++) {
        if (GetElmt(T,i).rating == R) {
            count++;
        }
    }
    return count;
}