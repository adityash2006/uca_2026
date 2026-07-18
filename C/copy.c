#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <unistd.h>

#define BUF_SIZE 1024

int main(int argc,char *argv[]){
    printf("%d",argc);
	

	int inputFd, outputFd, openFlags;
	mode_t filePerms;
	ssize_t numRead;
    // ssize also gives -1 size only gives 0 or data byte pointer hatever
	char buf[BUF_SIZE];

	if(argc!=3) {
	printf("usage is ./a.out file1 file2");
	exit(-1);
	}	
	
	inputFd= open(argv[1],O_RDONLY);
	if(inputFd==-1) {
	printf("Error opeingn file %s\n",argv[1]);
	exit(-1);
    }
openFlags = O_CREAT | O_WRONLY | O_TRUNC;
filePerms = S_IRUSR | S_IWUSR | S_IRGRP | S_IROTH; // rw-r-r- 644
outputFd=open(argv[2],openFlags, filePerms);


if(outputFd == -1) {
	printf("error opening file %s\n",argv[2]);
	exit(-1);
}
// hw check what is that command which gives the correct error that what exactly happened 
// you provide buffer size of chunks so the ram doesn't gets filled up
// numread will store number of bytes read 
while ((numRead = read(inputFd, buf, BUF_SIZE)) > 0){
	if (write(outputFd, buf, numRead)!=numRead){
	printf("Some problem occurred");
	exit(-1);
	}
}

close(inputFd);
close(outputFd);

return 0;
	
}