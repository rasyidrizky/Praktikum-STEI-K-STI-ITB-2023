#include <stdio.h>
#include "blockchain.h"

/* Menghitung hash value untuk blok baru */
/* I.S. Parameter block terdefinisi */
/* F.S. Mengembalikan nilai hash yang merupakan jumlah dari prevHash, data, dan timestamp */
infotype computeHash(BlockData block) {
    return block.data + block.prevHash + block.timestamp;
}

/* I.S. blockchain kosong */
/* F.S. blockchain terisi dengan genesis block yang memiliki:
        - prevHash = 0
        - data = jumlah ASCII dari string "Satomoto"
        - timestamp = 0 */
void initBlock(List *blockchain) {
    CreateEmpty(blockchain);

    BlockData genesisBlock;
    genesisBlock.prevHash = 0;
    genesisBlock.data = 'S' + 'a' + 't' + 'o' + 'm' + 'o' + 't' + 'o';
    genesisBlock.timestamp = 0;

    address P = Alokasi(genesisBlock);
    if (P != Nil) {
        InsertLast(blockchain, P);
    }
}

/* Menambahkan blok baru ke blockchain */
/* I.S. blockchain terdefinisi dan tidak kosong (minimal berisi genesis block) */
/* F.S. Sebuah blok baru ditambahkan ke akhir blockchain dengan:
        - prevHash = hash dari blok sebelumnya
        - data = value yang diberikan
        - timestamp = waktu yang diberikan */
void addBlock(List *blockchain, infotype value, infotype timestamp) {
    address Last = First(*blockchain);
    while (Next(Last) != Nil) {
        Last = Next(Last);
    }

    BlockData newBlock;
    newBlock.prevHash = computeHash(Info(Last));
    newBlock.data = value;
    newBlock.timestamp = timestamp;

    address New = Alokasi(newBlock);
    if (New != Nil) {
        InsertLast(blockchain, New);
    }
}

/* Memvalidasi integritas blockchain */
/* I.S. blockchain terdefinisi */
/* F.S. Mengembalikan true jika:
        - blockchain kosong atau hanya berisi 1 blok (genesis), atau
        - Semua blok memiliki hash yang valid dan terhubung dengan benar
        Mengembalikan false jika ada blok yang tidak valid atau tidak terhubung dengan benar */
boolean validateChain(List blockchain) {
    if (IsEmpty(blockchain) || NbElmt(blockchain) == 1) {
        return true;
    }

    address P = First(blockchain);
    while (Next(P) != Nil) {
        if (computeHash(Info(P)) != PrevHash(Next(P))) {
            return false;
        }
        P = Next(P);
    }

    return true;
}

/* Menampilkan seluruh blok dalam blockchain */
/* I.S. blockchain terdefinisi */
/* F.S. Seluruh blok dalam blockchain ditampilkan ke layar dalam format:
        [
          Block 1: {            // indentasi 2 spasi
            prevHash: <nilai>,  // indentasi 4 spasi
            data: <nilai>,      // indentasi 4 spasi
            timestamp: <nilai>  // indentasi 4 spasi
          },                    // indentasi 2 spasi (tambahkan koma apabila bukan block terakhir)
          ...
        ]
        Jika blockchain kosong, menampilkan "[]" */
void printBlockchain(List blockchain) {
    if (IsEmpty(blockchain)) {
        printf("[]\n");
    } else {
        address P = First(blockchain);
        int i = 1;
        printf("[\n");
        while (P != Nil) {
            printf("  Block %d: {\n", i);
            printf("    prevHash: %llu,\n", PrevHash(P));
            printf("    data: %llu,\n", Data(P));
            printf("    timestamp: %llu\n", Timestamp(P));
            
            if (Next(P) == Nil) {
                printf("  }\n");
            } else {
                printf("  },\n");
            }

            P = Next(P);
            i++;
        }
        printf("]\n");
    }
}

/* Menghitung rata-rata nilai data dari semua block */
/* I.S. blockchain terdefinisi */
/* F.S. Mengembalikan rata-rata nilai data dari semua block dalam blockchain */
/* Jika blockchain kosong, mengembalikan 0 */
double getAverageData(List blockchain) {
    if (IsEmpty(blockchain)) {
        return 0;
    } else {
        double Sum = 0, Elmt = 0;
        address P = First(blockchain);

        while (P != Nil) {
            Sum += Data(P);
            Elmt++;
            P = Next(P);
        }

        return (Sum/Elmt);
    }
}

/* Mencari block dengan nilai data terbesar */
/* I.S. blockchain terdefinisi */
/* F.S. Mengembalikan pointer ke block dengan nilai data terbesar */
/* Jika blockchain kosong, mengembalikan NULL */
address findLargestDataBlock(List blockchain) {
    if (IsEmpty(blockchain)) {
        return NULL;
    } else {
        address P = First(blockchain);
        infotype Max = Data(P);
        address PMax = P;

        P = Next(P);
        while (P != Nil) {
            if (Max < Data(P)) {
                Max = Data(P);
                PMax = P;
            }
            P = Next(P);
        }

        return PMax;
    }
}