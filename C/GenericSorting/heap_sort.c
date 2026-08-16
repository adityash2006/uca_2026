#include <stdio.h>
#include <string.h>
#include <stdlib.h>


void heapify (void* arr, int position, int size,int shiftSize,int (*cmp)(void *, void *)){

    int now = position;
    while(true){
        int left = 2*now + 1;
        int right = 2*now +2;

        int largest = now;

        if(left < size && cmp((char *)arr+left*shiftSize,(char *)arr+largest*shiftSize)>0){
            largest = left;
        }

        if(right < size && cmp((char *)arr+right*shiftSize,(char *)arr+largest*shiftSize)>0){
            largest = right;
        }

        if(now == largest){
            break;
        }

        void* temp = malloc(shiftSize);
        void* lg = (char *)arr+largest*shiftSize;
        void* curr = (char *)arr+now*shiftSize;

        memcpy(temp,lg,shiftSize);
        memcpy(lg,curr,shiftSize);
        memcpy(curr,temp,shiftSize);

        now = largest;
        free(temp);
      
    }

}

void heapSort(void* arr,int size,int shiftSize,int (*cmp)(void *, void *)){

    for(int i=size/2+1;i>=0;i--){
        heapify(arr,i,size,shiftSize,cmp);
    }

    for(int i=size-1; i>=0 ; i--){
        
        void *temp = malloc(shiftSize);
        char *root = (char *)arr;
        char *last = (char *)arr + shiftSize * i;

        memcpy(temp, root, shiftSize);
        memcpy(root, last, shiftSize);
        memcpy(last, temp, shiftSize);

        free(temp);
        heapify(arr,0,i,shiftSize,cmp);
    }
}
int intCompare(void *a, void *b)
{
    int x = *(int *)a;
    int y = *(int *)b;

    if (x > y) return 1;
    if (x < y) return -1;
    return 0;
}

int doubleCompare(void *a, void *b)
{
    double x = *(double *)a;
    double y = *(double *)b;

    if (x > y) return 1;
    if (x < y) return -1;
    return 0;
}

int floatCompare(void *a, void *b)
{
    float x = *(float *)a;
    float y = *(float *)b;

    if (x > y) return 1;
    if (x < y) return -1;
    return 0;
}

int charCompare(void *a, void *b)
{
    char x = *(char *)a;
    char y = *(char *)b;

    if (x > y) return 1;
    if (x < y) return -1;
    return 0;
}

int main(){
    // int arr[] ={7,34,2,1,4,6};
    // heapSort(arr,sizeof(arr)/sizeof(int),sizeof(int),intCompare);

     float arr[] ={7.4,34.3,2.0,1.3,4,6};
    heapSort(arr,sizeof(arr)/sizeof(float),sizeof(float),floatCompare);
    for(int i=0;i<6;i++){
        printf("%.2f \n",arr[i]);
    }
    
    return 0;
}