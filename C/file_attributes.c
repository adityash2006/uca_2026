#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <time.h>
#include <string.h>

int main(int argc, char *argv[])
{
    struct stat fileStat;
    if (argc != 2)
    {
        printf("Usage: %s filename\n", argv[0]);
        return 1;
    }

 
    if (stat(argv[1], &fileStat) == -1)
    {
        perror("stat");
        return 1;
    }

   
    char *fileType;

    if (S_ISREG(fileStat.st_mode))
        fileType = "Regular File";
    else if (S_ISDIR(fileStat.st_mode))
        fileType = "Directory";
    else if (S_ISLNK(fileStat.st_mode))
        fileType = "Symbolic Link";
    else if (S_ISCHR(fileStat.st_mode))
        fileType = "Character Device";
    else if (S_ISBLK(fileStat.st_mode))
        fileType = "Block Device";
    else if (S_ISFIFO(fileStat.st_mode))
        fileType = "FIFO (Pipe)";
    else if (S_ISSOCK(fileStat.st_mode))
        fileType = "Socket";
    else
        fileType = "Unknown";

    printf("=== File Attributes for: %s ===\n", argv[1]);
    printf("File Type:            %s\n", fileType);
    printf("Permissions:          %04o\n", fileStat.st_mode & 0777);
    printf("File Size:            %ld bytes\n", (long)fileStat.st_size);
    printf("Hard Links Count:     %ld\n", (long)fileStat.st_nlink);
    printf("Owner (UID):          %d\n", fileStat.st_uid);
    printf("Group (GID):          %d\n", fileStat.st_gid);

    printf("Last Access Time:     %s", ctime(&fileStat.st_atime));
    printf("Last Modification:    %s", ctime(&fileStat.st_mtime));
    printf("Status Change Time:   %s", ctime(&fileStat.st_ctime));

    return 0;
}