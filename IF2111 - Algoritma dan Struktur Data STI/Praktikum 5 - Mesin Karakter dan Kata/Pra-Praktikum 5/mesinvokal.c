#include <stdio.h>
#include "mesinkarakter.h"
#include "boolean.h"

int main() {
    int count = 0;
    char except;
    char vowels[100];
    int index = 0;

    scanf("%c", &except);

    START();

    while (!IsEOP()) {
        if (((GetCC() == 'A') 
        || (GetCC() == 'I') 
        || (GetCC() == 'U') 
        || (GetCC() == 'E') 
        || (GetCC() == 'O') 
        || (GetCC() == 'a') 
        || (GetCC() == 'i') 
        || (GetCC() == 'u') 
        || (GetCC() == 'e') 
        || (GetCC() == 'o')) && (GetCC() != except)) {
            vowels[index++] = GetCC();
            count++;
        }
        
        ADV();
    }

    if (count > 0) {
        for (int i = 0; i < index; i++) {
            printf("%c", vowels[i]);
        }
        printf(" %d\n", count);
    } else {
        printf("0\n");
    }

    return 0;

}