import sys
input=sys.stdin.readline
q=int(input().strip())
vol=0
play=False
for _ in range(q):
    ope=int(input())
    if ope==1:
        vol+=1
    elif ope==2:
        if vol>0:
            vol-=1
    else:
        play=not play
    print("Yes" if play and vol>=3 else "No")
    