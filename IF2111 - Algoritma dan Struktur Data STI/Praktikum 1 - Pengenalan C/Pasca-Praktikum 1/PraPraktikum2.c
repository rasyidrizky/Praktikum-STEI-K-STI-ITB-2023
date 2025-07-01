#include <stdio.h>

int main() {
    int N;
    int i;

    scanf("%d", &N);

    for(i=1;i<=N;i++) {
        if ((i%7 == 0) && (i%2 == 0 || i%5 == 0)) {
            printf("RonaldoMessi\n");
        } else if (i%7 == 0) {
            printf("Ronaldo\n");
        } else if ((i%2 == 0) || (i%5 == 0)) {
            printf("Messi\n");
        } else { 
            printf("%d\n",i); 
        }
    }
    return 0;
}