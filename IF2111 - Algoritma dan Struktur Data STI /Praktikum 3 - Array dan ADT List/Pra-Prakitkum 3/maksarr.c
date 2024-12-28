#include <stdio.h>

int main() {
    int N;
    int i;
    int Max = -9999;
    int count = 0;

    scanf("%d", &N);

    int arr[N];

    //Masukkan elemen arr
    for (i = 0; i < N; i++) {
        scanf("%d", &arr[i]);
    }

    //Mencari nilai maks
    for (i = 0; i < N; i++) {
        if (arr[i] > Max) {
            Max = arr[i];
        }
    }

    //Mencari banyak kemunculan maks
    for (i = 0; i < N; i++) {
        if (Max == arr[i]) {
            count++;
        }
    }
    printf("%d %d\n", Max, count);

    //Mencari indeks max
    for (i = 0; i < N; i++) {
        if (Max == arr[i]) {
            printf("%d ", i);
        }
    }

    printf("\n");

    return 0;
}