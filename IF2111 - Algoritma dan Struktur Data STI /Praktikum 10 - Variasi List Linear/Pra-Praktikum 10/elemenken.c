/* Tuliskan header di sini berisi nama, dll */

#include <stdio.h>
#include "listsirkuler.h"

int ElemenKeN(List L, int r) {
    int idx = 0;
    address p = First(L);

    /* Tuliskan implementasi di sini */
    while (idx != r) {
        p = Next(p);
        idx++;
    }

    return Info(p);
}

int main () {
    List L;
    int r, N;
    boolean stop = false;

    /* Tuliskan implementasi di sini */
    CreateEmpty(&L);
    
    while (!stop) {
        scanf("%d", &N);

        if (N == 0) {
            stop = true;
        } else {
            InsVLast(&L,N);
        }
    }

    scanf("%d", &r);

    if (IsEmpty(L)) {
        printf("List Kosong\n");
    } else {
        printf("%d\n", ElemenKeN(L,r));
    }

    return 0;
}