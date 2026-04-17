#include <stdio.h>
#include <string.h>
#define MOD 1000000007
#define MAX_X 1000005

typedef long long ll;

int main(){
    int n,x;
    ll c[105];
    scanf("%d %d",&n,&x);
    for (int i=0;i<n;i++){
        scanf("%lld",&c[i]);
    }
    
    ll dp[MAX_X];
    memset(dp,0,sizeof(dp));
    dp[0]=1;

    for (int i=0;i<n;i++){
        for(int j=c[i];j<=x;j++){
            dp[j]=(dp[j]+dp[j-c[i]])%MOD;
        
        }
    }
    printf("%lld\n",dp[x]);
    return 0;

    
}