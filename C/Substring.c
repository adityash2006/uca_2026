#include <stdio.h>

int find_substring(const char *haystack, const char *needle){

    int index = 0;
      while(*haystack!='\0'){
        
        const char *i= haystack;
        if(*haystack==*needle){
            const char *j=needle;
            while(*j!='\0'){
                if(*i==*j){
                    i++;
                    j++;
                }else{
                    break;
                }
            }
            if(*j=='\0'){
                return index;
            }
        }
        haystack++;
        index++;
      }

      return -1;
}

int main(){

    int index = find_substring("Em Systems","ms");
    printf("%d \n",index);
    return 0;
}