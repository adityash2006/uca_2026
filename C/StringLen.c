#include <stdio.h>


int my_strlen(const char *str){
    int len = 0;
    while(*str!='\0'){
        len++;
        str+=1;
    }
    return len;
}

int main(){
    int len=my_strlen("adi");
    printf("%d\n",len);

    return 0;
}