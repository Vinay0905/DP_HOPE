import sys

MOD = 10**9 + 7

def solve():
    input = sys.stdin.readline
    t = int(input())

    max_n = 2 * 10**5
    fact = [1] * (max_n + 1)
    for i in range(1, max_n + 1):
        fact[i] = fact[i - 1] * i % MOD

    for _ in range(t):
        n, c = map(int, input().split())
        s = input().strip()

        if s[0] == '0':
            print(-1)
            continue

        ones_positions = [i for i, ch in enumerate(s) if ch == '1']

        if not ones_positions:
            print(-1)
            continue

        L = ones_positions[0]
        R = ones_positions[-1]

        valid = True
        for i in range(L, R + 1):
            if s[i] == '0':
                valid = False
                break

        if not valid:
            print(-1)
            continue

        k = R - L + 1
        f_value = fact[k] * (n - k + 1) % MOD

        if f_value % c == 0:
            print(-1)
        else:
            print(f_value)


if __name__ == "__main__":
    solve()
