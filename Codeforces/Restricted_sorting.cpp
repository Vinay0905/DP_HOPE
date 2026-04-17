// #include <bits/stdc++.h>
// using namespace std;
// class DSU {
//     vector<int>parent;
// public:
//     DSU(int n):parent(n){
//         iota(parent.begin(),parent.end(),0);
//     }
//     int find(int x) {
//         if(parent[x]!=x)
//             parent[x]=find(parent[x]);
//         return parent[x];
//     }
//     void unite(int x,int y){
//         x=find(x);
//         y=find(y);
//         if(x!=y)
//             parent[x]=y;
//     }
// };
// bool c_s(vector<int>& a, int k) {
//     int n=a.size();
//     DSU dsu(n);
//     for (int i=0;i<n;i++) {
//         for (int j=i+1;j<n;j++){
//             if (abs(a[i]-a[j])>=k){
//                 dsu.unite(i,j);
//             }
//         }
//     }
//     vector<int> s_a=a;
//     sort(s_a.begin(),s_a.end());
//     map<int, vector<int>> t_p;
//     for (int i = 0; i < n; i++) {
//         t_p[s_a[i]].push_back(i);
//     }
//     vector<bool>used(n,false);
//     for (int i=0;i<n;i++) {
//         bool found=false;
//         for (int j:t_p[a[i]]) {
//             if (!used[j]&&dsu.find(i)==dsu.find(j)) {
//                 used[j]=true;
//                 found=true;
//                 break;
//             }
//         }
//         if (!found)return false;
//     }
//     return true;
// }
// void solve() {
//     int n;
//     cin>>n;
//     vector<int>a(n);
//     for (int i=0;i<n;i++) {
//         cin>>a[i];
//     }
//     vector<int> s_a = a;
//     sort(s_a.begin(), s_a.end());
//     if (a == s_a) {
//         cout << -1 << "\n";
//         return;
//     }
//     set<int>u_s(a.begin(),a.end());
//     vector<int>u_v(u_s.begin(), u_s.end());
//     set<int> cand_s;
//     for (int i=0;i<u_v.size();i++) {
//         for (int j=i+1;j<u_v.size();j++) {
//             cand_s.insert(u_v[j] -u_v[i]);
//         }
//     }
//     if (cand_s.empty()) {
//         cout<<-1<<"\n";
//         return;
//     }
//     vector<int>candia(cand_s.begin(), cand_s.end());
//     int l=0,r=candia.size()-1;
//     int answer=-1;
    
//     while (l<=r) {
//         int mid=(l + r) / 2;
//         if (c_s(a,candia[mid])) {
//             answer=candia[mid];
//             l=mid+1;
//         } else{
//             r=mid-1;
//         }
//     }
    
//     cout<<answer<<"\n";
// }
// int main() {
//     ios_base::sync_with_stdio(false);
//     cin.tie(NULL);   
//     int t;
//     cin>>t;
//     while(t--) {
//         solve();
//     }
//     return 0;
// }

#include <bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; 
    if(!(cin>>T))return 0;
    while (T--){
        int n;cin>>n;
        vector<long long>anti1(n),bon(n);
        for(auto &x:anti1)cin>>x;
        bon=anti1;
        sort(bon.begin(),bon.end());
        if (anti1==bon){cout<<-1<<'\n';continue; }
        long long ans=0;
        for (int i=0;i<n;++i)
            ans=max(ans,llabs(anti1[i]-bon[i]));
        cout<<ans<<'\n';
    }
    return 0;
}