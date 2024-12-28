#include <stdio.h>

int main() {
    int kH, kM, kB;
    int H = 0, M = 0, B = 0;
    int bola;
    char perintah = 'A';

    scanf("%d %d %d", &kH, &kM, &kB);

    while (perintah != 'E') {
        scanf("%c", &perintah);

        if (perintah != 'E') {
            scanf("%d", &bola);

            if (perintah == 'H') {
                H += bola;
            } else if (perintah == 'M') {
                M += bola;
            } else if (perintah == 'B') {
                B += bola;
            }
        }

    }
    
    printf("%d %d %d\n", H, M, B);

    if ((H+M+B > 0) && (H <= kH) && (M <= kM) && (B <= kB)) {
        printf("Ya\n");
    } else {
        printf("Tidak\n");
    }

    return 0;
}