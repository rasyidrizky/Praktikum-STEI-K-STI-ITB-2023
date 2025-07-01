#include <stdio.h>
#include "boolean.h"
#include "map.h"

int main() {
    Map hasil;
    valuetype N, K;
    address i, j;
    valuetype total = 0;

    CreateEmpty(&hasil);

    scanf("%d %d", &N, &K);

    for (i = 0; i < N; i++) {
        valuetype value;
        scanf("%d", &value);
        Insert(&hasil, i, value);
    }

    for (i = 0; i < N; i++) {
        for (j = i + 1; j < N; j++) {
            if ((Value(hasil, i) + Value(hasil, j)) == K) {
                total++;
            }
        }
    }

    printf("%d\n", total);
    return 0;
}