#include <stdio.h>

int sign(int number) {
    return (number >> 31) | (!!number);
}

int main(){
    int ans = sign(-4);
    printf("%d",ans);
    return 0;
}