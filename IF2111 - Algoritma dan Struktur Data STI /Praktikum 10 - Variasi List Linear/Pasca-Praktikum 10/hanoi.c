#include "stacklinked.h"
#include <stdio.h>
#include <stdlib.h>

int main() {
    int baris = 1, N, Si, Di, sampah;
    Stack M1, M2, M3;
    boolean cancel;

    CreateStack(&M1);
    CreateStack(&M2);
    CreateStack(&M3);

    push(&M1,5);
    push(&M1,4);
    push(&M1,3);
    push(&M1,2);
    push(&M1,1);

    scanf("%d", &N);

    while (baris <= N) {
        cancel = true;

        scanf("%d %d", &Si, &Di);

        if (Si == 1) {
            if (isEmpty(M1)) {
                printf("Menara kosong\n");
            } else {
                pop(&M1, &sampah);
                cancel = false;
            }
        } else if (Si == 2) {
            if (isEmpty(M2)) {
                printf("Menara kosong\n");
            } else {
                pop(&M2, &sampah);
                cancel = false;
            }
        } else if (Si == 3) {
            if (isEmpty(M3)) {
                printf("Menara kosong\n");
            } else {
                pop(&M3, &sampah);
                cancel = false;
            }
        }

        if (!cancel) {
            if (Di == 1) {
                if (ADDR_TOP(M1) != NIL && TOP(M1) < sampah) {
                    printf("Piringan tidak dapat dipindah\n");
                    if (Si == 1) {
                        push(&M1, sampah);
                    } else if (Si == 2) {
                        push(&M2, sampah);
                    } else if (Si == 3) {
                        push(&M3, sampah);
                    }
                } else {
                    push(&M1,sampah);
                }
            } else if (Di == 2) {
                if (ADDR_TOP(M2) != NIL && sampah > TOP(M2)) {
                    printf("Piringan tidak dapat dipindah\n");
                    if (Si == 1) {
                        push(&M1, sampah);
                    } else if (Si == 2) {
                        push(&M2, sampah);
                    } else if (Si == 3) {
                        push(&M3, sampah);
                    }
                } else {
                    push(&M2,sampah);
                }
            } else if (Di == 3) {
                if (ADDR_TOP(M3) != NIL && sampah > TOP(M3)) {
                    printf("Piringan tidak dapat dipindah\n");
                    if (Si == 1) {
                        push(&M1, sampah);
                    } else if (Si == 2) {
                        push(&M2, sampah);
                    } else if (Si == 3) {
                        push(&M3, sampah);
                    }
                } else {
                    push(&M3,sampah);
                }
            }
        }

        baris++;
    }

    printf("Menara 1: ");
    DisplayStack(M1);
    printf("\n");

    printf("Menara 2: ");
    DisplayStack(M2);
    printf("\n");

    printf("Menara 3: ");
    DisplayStack(M3);
    printf("\n");
    
    return 0;
}