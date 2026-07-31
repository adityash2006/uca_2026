#include<stdio.h>

int isPower2(int num) {
  return !!num & !(num >> 31) & !(num & (num + ~0));
}


int main(){
    int ans = isPower2(5);
    printf("%d",ans);
    return 0;
}