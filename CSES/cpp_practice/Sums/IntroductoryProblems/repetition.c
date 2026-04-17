#include <stdio.h>
#include <string.h>

int main() {
    char s[1000005];
    scanf("%s", s);

    int max_len = 1, curr = 1;
    int n = strlen(s);

    for (int i = 1; i < n; i++) {
        if (s[i] == s[i - 1])
            curr++;
        else
            curr = 1;

        if (curr > max_len)
            max_len = curr;
    }

    printf("%d\n", max_len);
    return 0;
}
