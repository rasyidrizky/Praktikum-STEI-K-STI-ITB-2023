#include "listlinierv2.h"

/* Menghitung hash value untuk blok baru */
/* I.S. Parameter block terdefinisi */
/* F.S. Mengembalikan nilai hash yang merupakan jumlah dari prevHash, data, dan timestamp */
infotype computeHash(BlockData block);

/* I.S. blockchain kosong */
/* F.S. blockchain terisi dengan genesis block yang memiliki:
        - prevHash = 0
        - data = jumlah ASCII dari string "Satomoto"
        - timestamp = 0 */
void initBlock(List *blockchain);

/* Menambahkan blok baru ke blockchain */
/* I.S. blockchain terdefinisi dan tidak kosong (minimal berisi genesis block) */
/* F.S. Sebuah blok baru ditambahkan ke akhir blockchain dengan:
        - prevHash = hash dari blok sebelumnya
        - data = value yang diberikan
        - timestamp = waktu yang diberikan */
void addBlock(List *blockchain, infotype value, infotype timestamp);

/* Memvalidasi integritas blockchain */
/* I.S. blockchain terdefinisi */
/* F.S. Mengembalikan true jika:
        - blockchain kosong atau hanya berisi 1 blok (genesis), atau
        - Semua blok memiliki hash yang valid dan terhubung dengan benar
        Mengembalikan false jika ada blok yang tidak valid atau tidak terhubung dengan benar */
boolean validateChain(List blockchain);

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
void printBlockchain(List blockchain);

/* Menghitung rata-rata nilai data dari semua block */
/* I.S. blockchain terdefinisi */
/* F.S. Mengembalikan rata-rata nilai data dari semua block dalam blockchain */
/* Jika blockchain kosong, mengembalikan 0 */
double getAverageData(List blockchain);

/* Mencari block dengan nilai data terbesar */
/* I.S. blockchain terdefinisi */
/* F.S. Mengembalikan pointer ke block dengan nilai data terbesar */
/* Jika blockchain kosong, mengembalikan NULL */
address findLargestDataBlock(List blockchain);
