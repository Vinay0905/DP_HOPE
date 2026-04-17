#include <stdio.h>
#include <string.h>

int main()
{
    int n;
    scanf("%d", &n);
    long long prev,curr;
    long long moves=0;
    scanf("%lld",&prev);
    for (int i=1;i<n;i++){
        scanf("%lld",&curr);
        if (curr<prev){
            moves+=(prev-curr);
        }
        else{
            prev=curr;

        }

    }
    printf("%lld",moves);
    return 0;

}