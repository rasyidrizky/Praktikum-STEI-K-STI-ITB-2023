#include <stdio.h>
// #include "stack.c"
#include "stack.h"

int main(){
    char tanda;
    int n;
    long total = 0;
    int val;
    int signval;
    Stack angka;
    Stack sign;
    CreateEmpty(&angka);
    CreateEmpty(&sign);
    scanf("%c", &tanda);
    while (tanda != '='){
        if (tanda == '+'){
            scanf("%d", &n);
            Push(&angka, n);
            Push(&sign, tanda);
            total += n;
        }
        else if (tanda == '-'){
            scanf("%d", &n);
            Push(&angka, n);
            Push(&sign, tanda);
            total -= n;
        }
        else if(tanda == 'u'){
            Pop(&angka,&val);
            Pop(&sign,&signval);
            if (signval == '+'){
                total -= val;
            }
            else if (signval == '-'){
                total += val;
            }
        }
        scanf("%c", &tanda);
    }

    printf("%ld\n",total);
}