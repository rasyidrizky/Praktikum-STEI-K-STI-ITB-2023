#include <stdio.h>
#include "stack.h"
#include "boolean.h"

Stack stack;
Stack maxStack;
Stack idxStack;

int main() {
    int q;
    int n;
    int y;
    int total = 0;
    
    scanf("%d", &q);
    
    int angkaarr[q];
    int idxarr[q];
    
    CreateEmpty(&stack);
    CreateEmpty(&maxStack);
    CreateEmpty(&idxStack);

    for (int i=0;i< q;i++) {
        scanf("%d", &n);

        if (n == 1) {
            scanf("%d", &y);
            Push(&stack, y);
            if (IsEmpty(maxStack) || y >= InfoTop(maxStack)){
            Push(&maxStack, y);
            Push(&idxStack,Top(stack));
            }
            
        } else if (n == 2) {
            int val;
            Pop(&stack,&val);
            
            if (val == InfoTop(maxStack)) {
                Pop(&maxStack,&val);
                Pop(&idxStack, &val);
                }

        } else if (n == 3) {
            angkaarr[total] = InfoTop(maxStack);
            idxarr[total] = InfoTop(idxStack)+1;
            total ++;
        }
    }

    for (int i = 0; i < total; i++) {
        printf("%d %d\n", idxarr[i], angkaarr[i]);
    }

}