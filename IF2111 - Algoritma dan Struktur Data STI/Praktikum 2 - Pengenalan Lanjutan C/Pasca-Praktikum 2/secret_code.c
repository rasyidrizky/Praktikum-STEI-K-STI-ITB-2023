#include <stdio.h>
#include "secret_code.h"

int count_length(char str[]) {
    int count = 0;
    int i = 0;

    while (str[i] != '#') {
        count++;
    }

    return count;
}

void print_decrypted(char str[]) {
    int j = 0;
    char kata[21];

    while (str[j] != '#') {
        if ((str[j] >= 'a' && str[j] <= 'z') || (str[j] >= 'A' && str[j] <= 'Z')) {
            printf("%c",str[j]);
        }
        j++;
    }

    printf("\n");
}