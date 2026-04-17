// #include <bits/stdc++.h>
// using namespace std;
// using ll = long long;
// const ll INF = (1LL<<62);
// struct Par {
//     int pp, qp, bp, bq;
//     bool ok;
// };
// pair<bool, pair<ll,ll>> solve_one(ll x, ll y, int tp, int tq, ll cp, ll cq) {
//     const int B=31;
//     ll d1p[2][2], n_dip[2][2];
//     Par par[B+1][2][2];
//     for(int i=0;i<2;i++) for(int j=0;j<2;j++) d1p[i][j]=INF;
//     d1p[0][0]=0;
//     for(int s=0;s<=B;s++) 
//         for(int i=0;i<2;i++) 
//             for(int j=0;j<2;j++) 
//             par[s][i][j]={0,0,0,0,false};
//     for(int s=0;s<B;s++){
//         int b=30-s;
//         int xb=(x>>b)&1;
//         int yb=(y>>b)&1;
//         for(int i=0;i<2;i++) 
//             for(int j=0;j<2;j++) 
//                 n_dip[i][j]=INF;

//         for(int fp=0;fp<2;fp++) 
//             for(int fq=0;fq<2;fq++){
//             ll cur=d1p[fp][fq];
//             if(cur>=INF) continue;
//             for(int k=0;k<3;k++){
//                 int bp=(k==2);
//                 int bq=(k==1);
//                 int nfp=fp,nfq=fq;

//                 if(tp==0){
//                     if(!fp){
//                         if(bp>xb) 
//                             continue;
//                         if(bp<xb) 
//                             nfp=1;
//                     }
//                 }else{
//                     if(!fp){
//                         if(bp<xb) 
//                             continue;
//                         if(bp>xb) 
//                             nfp=1;
//                     }
//                 }

//                 if(tq==0){
//                     if(!fq){
//                         if(bq>yb) 
//                             continue;
//                         if(bq<yb) 
//                             nfq=1;
//                     }
//                 }else{
//                     if(!fq){
//                         if(bq<yb) 
//                             continue;
//                         if(bq>yb) 
//                             nfq=1;
//                     }
//                 }

//                 ll add=cp*(ll(bp)<<b)+cq*(ll(bq)<<b);
//                 ll val=cur+add;
//                 if(val<n_dip[nfp][nfq]){
//                     n_dip[nfp][nfq]=val;
//                     par[s+1][nfp][nfq]={fp,fq,bp,bq,true};
//                 }
//             }
//         }
//         for(int x=0;x<2;x++) 
//             for(int y=0;y<2;y++) 
//                 d1p[x][y]=n_dip[x][y];
//     }
//     ll best=INF; int fp=0,fq=0;
//     for(int i=0;i<2;i++) 
//         for(int j=0;j<2;j++){
//         if(d1p[i][j]<best){
//             best=d1p[i][j]; 
//             fp=i; 
//             fq=j;
//         }
//     }
//     if(best>=INF) 
//         return {false,{0,0}};

//     ll p=0,q=0;
//     for(int s=B;s>=1;s--){
//         Par e=par[s][fp][fq];
//         if(!e.ok) 
//             return{false,{0,0}};
//         int b=30-(s-1);
//         if(e.bp) p |= (1LL<<b);
//         if(e.bq) q |= (1LL<<b);
//         fp=e.pp; fq=e.qp;
//     }
//     return {true,{p,q}};
// }

// int main(){
//     ios::sync_with_stdio(false);
//     cin.tie(nullptr);
//     int t; cin>>t;
//     while(t--){
//         ll x,y; cin>>x>>y;
//         ll bestCost = INF;
//         ll bestP=0, bestQ=0;
//         auto try_case = [&](int tp,int tq,ll cp,ll cq){
//             auto r = solve_one(x,y,tp,tq,cp,cq);
//             if(!r.first) return;
//             ll p=r.second.first, q=r.second.second;
//             if((p&q)!=0) return;
//             ll cost = llabs(x-p) + llabs(y-q);
//             if(cost < bestCost){
//                 bestCost=cost; bestP=p; bestQ=q;
//             }
//         };
//         try_case(0,0,-1,-1);
//         try_case(1,1, 1, 1);
//         try_case(0,1,-1, 1);
//         try_case(1,0, 1,-1);
//         cout<<bestP<<" "<<bestQ<<"\n";
//     }
//     return 0;
// }


#include <bits/stdc++.h>
using namespace std;

using ll = long long;
const ll INF = (1LL<<62);

struct Par {
    int pp, qp, bp, bq;
    bool ok;
};

pair<bool, pair<ll,ll>> solve_one(ll x, ll y, int tp, int tq, ll cp, ll cq) {
    const int B = 31; // bits 30..0
    ll dp[2][2], ndp[2][2];
    Par par[B+1][2][2];
    for(int i=0;i<2;i++) for(int j=0;j<2;j++) dp[i][j]=INF;
    dp[0][0]=0;
    for(int s=0;s<=B;s++) for(int i=0;i<2;i++) for(int j=0;j<2;j++) par[s][i][j] = {0,0,0,0,false};

    for(int s=0;s<B;s++){
        int b = 30 - s;
        int xb = (x>>b)&1;
        int yb = (y>>b)&1;
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) ndp[i][j]=INF;

        for(int fp=0;fp<2;fp++) for(int fq=0;fq<2;fq++){
            ll cur = dp[fp][fq];
            if(cur>=INF) continue;
            for(int k=0;k<3;k++){
                int bp = (k==2); // 0,0 ; 0,1 ; 1,0
                int bq = (k==1);
                int nfp=fp, nfq=fq;

                if(tp==0){
                    if(!fp){
                        if(bp>xb) continue;
                        if(bp<xb) nfp=1;
                    }
                }else{
                    if(!fp){
                        if(bp<xb) continue;
                        if(bp>xb) nfp=1;
                    }
                }

                if(tq==0){
                    if(!fq){
                        if(bq>yb) continue;
                        if(bq<yb) nfq=1;
                    }
                }else{
                    if(!fq){
                        if(bq<yb) continue;
                        if(bq>yb) nfq=1;
                    }
                }

                ll add = cp*(ll(bp)<<b) + cq*(ll(bq)<<b);
                ll val = cur + add;
                if(val < ndp[nfp][nfq]){
                    ndp[nfp][nfq]=val;
                    par[s+1][nfp][nfq] = {fp,fq,bp,bq,true};
                }
            }
        }
        for(int i=0;i<2;i++) for(int j=0;j<2;j++) dp[i][j]=ndp[i][j];
    }

    ll best=INF; int fp=0,fq=0;
    for(int i=0;i<2;i++) for(int j=0;j<2;j++){
        if(dp[i][j]<best){
            best=dp[i][j]; fp=i; fq=j;
        }
    }
    if(best>=INF) return {false,{0,0}};

    ll p=0,q=0;
    for(int s=B;s>=1;s--){
        Par e = par[s][fp][fq];
        if(!e.ok) return {false,{0,0}};
        int b = 30 - (s-1);
        if(e.bp) p |= (1LL<<b);
        if(e.bq) q |= (1LL<<b);
        fp=e.pp; fq=e.qp;
    }
    return {true,{p,q}};
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t; cin>>t;
    while(t--){
        ll x,y; cin>>x>>y;

        ll bestCost = INF;
        ll bestP=0, bestQ=0;

        auto try_case = [&](int tp,int tq,ll cp,ll cq){
            auto r = solve_one(x,y,tp,tq,cp,cq);
            if(!r.first) return;
            ll p=r.second.first, q=r.second.second;
            if((p&q)!=0) return;
            ll cost = llabs(x-p) + llabs(y-q);
            if(cost < bestCost){
                bestCost=cost; bestP=p; bestQ=q;
            }
        };

        // A: p<=x, q<=y, maximize p+q -> minimize -(p+q)
        try_case(0,0,-1,-1);
        // B: p>=x, q>=y, minimize p+q
        try_case(1,1, 1, 1);
        // C: p<=x, q>=y, minimize (q-p) -> minimize (-p + q)
        try_case(0,1,-1, 1);
        // D: p>=x, q<=y, minimize (p-q) -> minimize (p - q)
        try_case(1,0, 1,-1);

        cout<<bestP<<" "<<bestQ<<"\n";
    }
    return 0;
}