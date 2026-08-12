#include <stdio.h>

int missingElement(int arr[],int size){
    int missingElement = 0;
        for(int bit = 0 ; bit < 32 ; bit++){
            int mask = 1 << bit;
            int countBits = 0;
            for(int i = 0 ;i < size ; i++){
                int element = arr[i];
                if((element & mask)!=0){
                    countBits++;
                }
            }
            if(countBits%3 !=0){
                missingElement = missingElement | mask;
            }
        }

    
    return missingElement;   
}

int main(){
    int arr[]={1, 2, 3, 4, 1, 2, 4, 1, 2, 3, 4, 3, 3};
    printf("%d",missingElement(arr,sizeof(arr)/sizeof(int)));

        return 0;
}   