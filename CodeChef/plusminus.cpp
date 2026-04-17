
#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    if(!(cin >> T)) return 0;
    while (T--) {
        int N;
        cin >> N;
        vector<long long> Arr(N);
        for (int i = 0; i < N; ++i) cin >> Arr[i];
        if (N == 1) { cout << "YES\n"; continue; }
        long long v = llabs(Arr[0]);
        bool al_bs = true;
        for (int i = 1; i < N; ++i) {
            if (llabs(Arr[i]) != v) { al_bs = false; break; }
        }
        if (!al_bs) { cout << "NO\n"; continue; }
        if (v == 0) { cout << "YES\n"; continue; }
        vector<int> s(N);
        for (int i = 0; i < N; ++i) s[i] = (Arr[i] >= 0 ? 1 : -1);
        int blcks = 1;
        for (int i = 1; i < N; ++i)
            if (s[i] != s[i-1]) ++blcks;
        if (blcks <= 2) cout << "YES\n"; else cout << "NO\n";
    }
    return 0;
}