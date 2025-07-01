#include <stdio.h>

int angkaMax(int array[]) {
    int i,j;
    int temp;
    int hasil = 0;

    for (i=0;i<4;i++) {
        for (j=0;j<3;j++) {
            if (array[j] < array[j+1]) {
                temp = array[j];
                array[j] = array[j+1];
                array[j+1] = temp;
            }
        }
    }
    for (i=0;i<4;i++) {
        hasil = hasil*10 + array[i];
    }
    return hasil;
}

int angkaMin(int array[]) {
    int i,j;
    int temp;
    int hasil = 0;

    for (i=0;i<4;i++) {
        for (j=0;j<3;j++) {
            if (array[j] > array[j+1]) {
                temp = array[j+1];
                array[j+1] = array[j];
                array[j] = temp;
            }
        }
    }
    for (i=0;i<4;i++) {
        hasil = hasil*10 + array[i];
    }
    return hasil;
}

int main() {
    int angka;
    int Max = 0, Min = 0;
    int arr[4];
    int count = 0;

    scanf("%d",&angka);

    while (angka != 6174) {

        for (int i=0;i<4;i++) {
            arr[i] = angka % 10;
            angka = angka / 10;
        }

        Max = angkaMax(arr);
        Min = angkaMin(arr);
        
        angka = Max - Min;

        if (angka == 0) {
            count = -1;
            angka = 6174;
        } else { count++; }
    }    

    printf("%d\n", count);

    return 0;
}