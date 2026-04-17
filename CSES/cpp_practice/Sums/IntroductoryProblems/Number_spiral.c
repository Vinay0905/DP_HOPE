// #include <stdio.h>
// #include <string.h>


// int main(){
//     int t;
//     scanf("%d",&t);
//     for (int i=0;i<t;i++){
//         int y,x;
//         scanf("%d %d",&y,&x);
//         long long n=(y>x)? y:x;
//         long long base =n*n-n+1;
//         long long ans;
//         if (n%2==0){
//             if(y==n){
//                 ans=base-(x-y);
//             }
//             else{
//                 ans=base+(y-x);

//             }

//         }
//         else{
//             if (x==n){
//                 ans=base-(y-x);
//             }
//             else{
//                 ans=base+(x-y);
//             }
//         }
//         printf("%lld\n",ans);


//     }
//     return 0;
// }
#include <stdio.h>

int main() {
    int t;
    scanf("%d", &t);
    for(int i = 0; i < t; i++) {
        long long r, c;
        scanf("%lld %lld", &r, &c);
        long long mx = (r > c ? r : c);
        long long mn = (r < c ? r : c);
        long long ans = mx * mx;
        if ((mx % 2) == (mn % 2)) {
            ans -= (mx - mn);
        } else {
            ans += (mx - mn);
        }
        printf("%lld\n", ans);
    }
    return 0;
}
