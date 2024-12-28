#include <stdio.h>
#include "listlinier.h"

int main() {
    int N, Q, i, nilai, sampah;
    List Check;
    address point;

    CreateEmpty(&Check);
    scanf("%d", &N);

    for (i = 1; i <= N; i++) {
        InsVLast(&Check, i);
    }

    scanf("%d", &Q);

    for (i = 0; i < Q; i++) {
        scanf("%d", &nilai);
        point = Search(Check, nilai);
        if (point != Nil) {
            DelP(&Check, nilai);
        } else {
            DelVLast(&Check, &sampah);
        }
        InsVFirst(&Check, nilai);

        if (point != Nil) {
            printf("hit ");
        } else {
            printf("miss ");
        }
        PrintInfo(Check);
        printf("\n");
    }

    return 0;
}