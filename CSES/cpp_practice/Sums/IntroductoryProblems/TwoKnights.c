#include <stdio.h>
#include <string.h>

int main(){
    long long n,i,tota_combination,attacking_knights;
    scanf("%lld",&n);
    for (i =1;i<=n;++i){
        tota_combination=((i*i)*((i*i)-1))/2;
        attacking_knights=4*(i-1)*(i-2);
        printf("%lld\n",tota_combination-attacking_knights);
    
    }
    
    return 0;


}