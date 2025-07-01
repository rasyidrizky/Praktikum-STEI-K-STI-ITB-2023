#include <stdio.h>

int main() {
    int Q, i;
    int jumlah, ronde;

    scanf("%d", &Q);

    for (i = 0; i < Q; i++) {
        scanf("%d", &jumlah);
        scanf("%d", &ronde);

        if (((jumlah / ronde) % 2) == 0) {
            printf("1\n");
        } else {
            printf("0\n");
        }

    }
    
    return 0;
}