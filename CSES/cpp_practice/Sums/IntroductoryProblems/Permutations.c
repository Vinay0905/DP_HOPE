#include <stdio.h>
#include <string.h>

int main(){
    int n;
    scanf("%d",&n);
    
    if (n ==2 || n==3){
        printf("NO SOLUTION\n");
        return 0;
    }
    // for (int i = n; i >= 1; i--) {
    //     if (i % 2 == 0) {
    //         printf("%d ", i);
    //     }
    // }

    // // Print odd numbers in descending order
    // for (int i = n; i >= 1; i--) {
    //     if (i % 2 == 1) {
    //         printf("%d ", i);
    //     }
    // }
    for (int i = 2; i <= n; i += 2) {
        printf("%d ", i);
    }

    // Print odd numbers in increasing order
    for (int i = 1; i <= n; i += 2) {
        printf("%d ", i);
    }
    printf("\n");
    return 0;

}