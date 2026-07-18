#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <string.h>



int main(int arc,char *argv[]){
    size_t len;
    off_t offset;
    int fd;
    char *buf;
    size_t numRead , numWritten;


    if (arc < 3 ) {
        printf("Usage is incorrect %s <file> {rlength|wstring|soffset} \n",argv[0]);
        exit(-1);
    }

    fd = open(argv[1], O_RDWR | O_CREAT, S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH); 

if (fd == -1) {
    perror("Failed to open the file");
    exit(-1);
    }

    for(int i=2;i<arc;i++){
        switch(argv[i][0]){
            case 'w':
                numWritten= write(fd,&argv[i][1],strlen(&argv[i][1]));
                printf("\n  number opf bytes written is %d \n",numWritten);
                break;
            case 'r':
                len= atoi(&argv[i][1]);
                buf=malloc(len);
                if (buf == NULL) {
                    perror("Malloc failed");
                    close(fd);
                    exit(-1);
                }
                numRead=read(fd,buf,len);

                if(numRead==0){
                    free(buf);
                    printf("we have reached at he end of the file \n");
                    exit(-1);
                }

                for(int j=0;j<numRead;j++){
                    printf("%c",((unsigned char)buf[j]));
                }
                printf("\n");
               
                free(buf);
                break;
                case 's':
                offset = atoi(&argv[i][1]);
                if(lseek(fd,offset, SEEK_CUR)==-1){
                    printf("Seek failed");
                    exit(-1);
                }
                printf("Seek Successful \n");
                break;
            default:
                printf("argumemt must be wrs  only \n");
                exit(-1);    
                
        }
    }
       exit(EXIT_SUCCESS);

}