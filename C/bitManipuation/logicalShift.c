#include <stdio.h>

int logicalShift(int x, int n) {
//   return ((x>>n) & ~(~0 << (32-n)));
 int mask = ~(((1 << 31) >> n) << 1);
    return (x >> n) & mask;
}

int main(){
    int ans = logicalShift(0x87654321,4);
    printf("%d",ans);
    return 0;
}