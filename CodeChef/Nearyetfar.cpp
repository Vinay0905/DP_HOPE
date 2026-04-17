
#include <bits/stdc++.h>
using namespace std;
using ll = long long;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int num;
    if (!(cin >> num)) return 0;
    while (num--) {
        int N, K;
        cin >> N >> K;
        vector<long long> Arr(N+1);
        for (int i = 1; i <= N; ++i) cin >> Arr[i];

        if (N <= 1){
            cout << 0 << '\n';
            continue;
        }

        long long ans = 0;

        if (K == 2) {
            long long mio = LLONG_MAX, mao = LLONG_MIN; int cO = 0;
            long long mie = LLONG_MAX, mae = LLONG_MIN; int ce = 0;
            for (int i = 1; i <= N; ++i) {
                if (i % 2 == 1) {
                    ++cO;
                    mio = min(mio, Arr[i]);
                    mao = max(mao, Arr[i]);
                } else {
                    ++ce;
                    mie = min(mie, Arr[i]);
                    mae = max(mae, Arr[i]);
                }
            }
            if (cO >= 2) ans = max(ans, mao - mio);
            if (ce >= 2) ans = max(ans, mae - mie);
            cout << ans << '\n';
            continue;
        }
        vector<long long> pref_m(N+1, LLONG_MAX), suf_min(N+2, LLONG_MAX);
        pref_m[1] = Arr[1];
        for (int i = 2; i <= N; ++i) pref_m[i] = min(pref_m[i-1], Arr[i]);
        suf_min[N] = Arr[N];
        for (int i = N-1; i >= 1; --i) suf_min[i] = min(suf_min[i+1], Arr[i]);

        for (int i = 1; i <= N; ++i) {
            long long mX = LLONG_MAX;
            if (i - 2 >= 1) mX = min(mX, pref_m[i-2]);
            if (i + 2 <= N) mX = min(mX, suf_min[i+2]);
            if (mX != LLONG_MAX) ans = max(ans, Arr[i] - mX);
        }

        cout << ans << '\n';
    }
    return 0;
}