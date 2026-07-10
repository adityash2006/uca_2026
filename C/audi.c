#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>
#include <sys/stat.h>


int main(int argc, char *argv[])
{
    int fd;

    if (argc < 2)
    {
        printf("Usage:\n");
        printf("./auditlog --add \"message\"\n");
        printf("./auditlog --view\n");
        exit(1);
    }

    if (strcmp(argv[1], "--add") == 0)
    {
        if (argc!= 3)
        {
            printf("Usage: ./auditlog --add \"message\"\n");
            exit(1);
        }

        fd = open("auditlog.txt",
                  O_CREAT | O_WRONLY | O_APPEND ,
                S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH);

        if (fd == -1){
            perror("open");
            exit(1);
        }

        write(fd, argv[2], strlen(argv[2]));
        write(fd, "\n", 1);
        close(fd);
    }
    else if (strcmp(argv[1], "--view") == 0)
    {
        if (argc != 2)
        {
            printf("Usage: ./auditlog --view\n");
            exit(1);
        }

        fd = open("auditlog.txt", O_RDONLY);

        if (fd == -1)
        {
            perror("open");
            exit(1);
        }


        char ch;
        int line=1;
        int newline=1;
    
        while(read(fd,&ch,1)>0){
            if(newline){
                printf("%d: ", line);
                newline=0;
            }
            printf("%c",ch);
            if(ch=='\n'){    
                line++;
                newline=1;
            }
        }
        printf("\n");

        close(fd);
    }
    else
    {
        printf("Unknown command.\n");
        printf("./auditlog --add \"message\"\n");
        printf("./auditlog --view\n");
    }

    return 0;
}