#include <stdio.h>

typedef long long ll;

int T;
ll X, Y;

ll solve(ll x, ll y) {
    ll l = (x > y ? x : y) - 1;
    if (l & 1) {
        if (x < y)
            return l * l + x;
        else
            return l * l + 2 * l - y + 2;
    } else {
        if (x < y)
            return l * l + 2 * l - x + 2;
        else
            return l * l + y;
    }
}

int main() {
    if (scanf("%d", &T) != 1) return 0;
    for (int t = 0; t < T; t++) {
        if (scanf("%lld %lld", &X, &Y) != 2) return 0;
        printf("%lld\n", solve(X, Y));
    }
    return 0;
}
