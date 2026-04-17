from collections import defaultdict
import sys
def Kadomatsu_Subsequence(n, arr):
    right=defaultdict(int)
    left=defaultdict(int)
    for v in arr:
        right[v]+=1

    rget=right.get
    lget=left.get
    ans=0
    j=0
    while j<n:
        v=arr[j]
        right[v]-=1
        if v%5 ==0:
            t =v//5
            v7 =7*t
            v3 =3*t
            ans+=rget(v7,0)*rget(v3,0)
            ans+=lget(v7,0)*lget(v3,0)
        left[v]+=1
        j+=1
    print(ans)


def main():
    input = sys.stdin.readline
    n = int(input())
    arr = list(map(int, input().split()))
    Kadomatsu_Subsequence(n, arr)


if __name__ == "__main__":
    main()
