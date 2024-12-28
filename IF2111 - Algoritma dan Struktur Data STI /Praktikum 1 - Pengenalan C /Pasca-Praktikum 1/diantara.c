#include <stdio.h>

int main() {
    int L;
    int R;
    int D;
    int count = 0;

    scanf("%d %d %d", &L, &R, &D);

    for (int i=L; i<=R; i++) {
        if (i % D == 0) {
            count += 1;
        }
    }

    printf("%d\n", count);

    return 0;
}