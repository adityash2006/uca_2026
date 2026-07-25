#include <stdio.h>

int main() {
    int c, next;

    while ((c = getchar()) != EOF) {

        // Handle string literals
        if (c == '"') {
            putchar(c);
            while ((c = getchar()) != EOF) {
                putchar(c);
                if (c == '\\') {
                    c = getchar();
                    if (c == EOF)
                        break;
                    putchar(c);
                } else if (c == '"') {
                    break;
                }
            }
        }

        // Handle character constants
        else if (c == '\'') {
            putchar(c);
            while ((c = getchar()) != EOF) {
                putchar(c);
                if (c == '\\') {
                    c = getchar();
                    if (c == EOF)
                        break;
                    putchar(c);
                } else if (c == '\'') {
                    break;
                }
            }
        }

        // Possible comment
        else if (c == '/') {
            next = getchar();

            // Single-line comment
            if (next == '/') {
                while ((c = getchar()) != EOF && c != '\n');
                if (c == '\n')
                    putchar('\n');
            }

            // Multi-line comment
            else if (next == '*') {
                int prev = 0;
                while ((c = getchar()) != EOF) {
                    if (prev == '*' && c == '/')
                        break;
                    prev = c;
                }
            }

            // Not a comment
            else {
                putchar(c);
                if (next != EOF)
                    ungetc(next, stdin);
            }
        }

        // Normal character
        else {
            putchar(c);
        }
    }

    return 0;
}

/* usage steps
gcc RemoveComments.c -o remove_comments
./remove_comments < sample.c this prints in the terminal
./remove_comments < sample.c > output.c this saves the output in the output file 

*/