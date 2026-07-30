#include <stdio.h>

int fitsBits(int x, int n) {
    int shift = 32 + (~n + 1);   // 32 - n
    return !(((x << shift) >> shift) ^ x);
}

int main(){
    int ans = fitsBits(-4,3);
    printf("%d",ans);
    return 0;
}