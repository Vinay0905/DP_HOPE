import sys

def main():
    input=sys.stdin.readline
    t=int(input())
    out=[]
    for _ in range(t):
        n=int(input())
        f=list(map(int, input().split()))
        a=[0]*n
        M=0
        T=0
        for i in range(1,n-1):
            a[i]=(f[i+1]-2*f[i]+f[i-1])//2
            M+=a[i]
            T+=i*a[i]
        a_n=(f[0]-T)//(n-1)
        a[-1]=a_n
        d1=f[1]-f[0]
        a[0]=d1+M+a_n
        out.append(' '.join(map(str, a)))
    sys.stdout.write('\n'.join(out))

if __name__ == '__main__':
    main()