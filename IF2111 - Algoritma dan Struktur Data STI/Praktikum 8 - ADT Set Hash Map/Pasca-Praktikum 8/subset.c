#include <stdio.h>
#include "subset.h"

boolean isSubset(Set S1, Set S2) {
/* Mengembalikan 1 apabila S1 adalah subset dari S2 */
/* Mengembalikan 0 apabila S1 bukan subset dari S2*/
/*
    S1 merupakan subset dari S2 berarti seluruh elemen dari
    S1 merupakan elemen dari S2. Ini juga berarti S2 adalah 
    superset dari S1. 

    Contoh input:
        Set 1 : [1, 2, 3]
        Set 2 : [1, 2, 3, 4]
    fungsi akan mengembalikan true karena seluruh elemen
    set 1 adalah bagian dari set 2

    Contoh input:
        Set 1 : [1, 5]
        Set 2 : [1, 2, 3, 4]
    fungsi akan mengembalikan false karena tidak seluruh elemen
    set 1 adalah bagian dari set 2

    ASUMSI : 
    1. Suatu set yang kosong adalah subset dari semua set
    2. Suatu set yang kosong tidak mungkin jadi superset untuk set yang tidak kosong
    3. Suatu set yang kosong adalah subset dari set yang kosong lainnya

    TIP : Ingat edge case ya kawan kawan! \(^_^\)
    Perhatikan asumsi yang diberikan!    
*/
    int i, j, count;
    boolean res = 1;

    if (IsEmpty(S1)) {
        return res;
    } else if (IsEmpty(S2)) {
        res = 0;
        return res;
    } else {
        for (i = 0; i < S1.Count; i++) {
            count = 0;
            for (j = 0; j < S2.Count; j++) {
                if (S1.Elements[i] == S2.Elements[j]) {
                    count++;
                }
            }
            if (count == 0) {
                res = 0;
                return res;
            }
        }
    }

    return res;
}