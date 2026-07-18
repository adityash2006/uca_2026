#include <stdio.h>
#include <string.h>

int main(){
    const char *deli=",";
    char msg[]="C,C++,Java,Python,Rust";
    char *token = strtok (msg, deli);
    
        while(token!=NULL){
            printf("%s \n",token);
            token=strtok(NULL,deli);
        }

    return 0;
}