#include<stdio.h>

int conditional(int x, int y, int z) {
  int mask = (x | (~x + 1)) >> 31;
  return ((mask & y ) | (~mask & z) );
}

int main(){
    int ans = conditional(2,3,5);
    printf("%d",ans);
    return 0;
}