#include <stdio.h>
void reverse_string(char *str){
    char *start=str;
    while(*str!='\0'){
        
        str+=1;
    }
    char *end=str-1;

    while(start<end){
        char temp=*start;
        *start=*end;
        *end=temp;

        start++;
        end--;
    }
}

int main(){

    char str[]="Data Structures";
    printf("Before reversing : %s  ",str);
    reverse_string(str);
    printf("\n After reversing : %s  \n",str);

    return 0;
}