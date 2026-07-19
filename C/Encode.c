#include <stdio.h>

void url_encode(char *str, int true_length) {
    int spaces = 0;

    
    for (int i = 0; i < true_length; i++) {
        if (str[i] == ' ')
            spaces++;
    }

    // New length after replacement
    int index = true_length + spaces * 2;

    // Null terminate the new string
    str[index] = '\0';

    // Traverse backwards
    for (int i = true_length - 1; i >= 0; i--) {
        if (str[i] == ' ') {
            str[index - 1] = '0';
            str[index - 2] = '2';
            str[index - 3] = '%';
            index -= 3;
        } else {
            str[index - 1] = str[i];
            index--;
        }
    }
}

int main() {
    char str[] = "Hello World    ";  
    int true_length = 11;
    url_encode(str, true_length);
    printf("%s\n", str);

    return 0;
}