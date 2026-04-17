import sys

def main():
    input = sys.stdin.readline
    t = int(input())
    out = []
    for _ in range(t):
        n, k = map(int, input().split())
        a = list(map(int, input().split()))
        if k == 2:
            max_o = min_o = a[0]
            max_ev = min_ev = a[1] if n > 1 else a[0]
            for i in range(2, n):
                if i % 2 == 0:
                    max_o = max(max_o, a[i])
                    min_o = min(min_o, a[i])
                else:
                    max_ev = max(max_ev, a[i])
                    min_ev = min(min_ev, a[i])
            ans = max(max_o - min_o, max_ev - min_ev)
            out.append(str(ans))
        else:
            ans = 0
            preMx = a[0]
            preMin = a[0]
            if n > 1:
                preMx = max(preMx, a[1])
                preMin = min(preMin, a[1])
            for i in range(2, n):
                ans = max(ans, a[i] - preMin, preMx - a[i])
                preMx = max(preMx, a[i])
                preMin = min(preMin, a[i])
            out.append(str(ans))
    sys.stdout.write("\n".join(out))
if __name__ == "__main__":
    main()