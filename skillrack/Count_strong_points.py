n,m=map(int,input().split())
# mat = [[int(input()) for _ in range(m)] for _ in range(n)]
matrix = [list(map(int, input().split())) for _ in range(n)]

strong=0

for r in range(n):
    for c in range(m):
        curr=matrix[r][c]
        is_strong=True
        for dr in [-1,0,1]:
            for dc in [-1,0,1]:
                if dr==0 and dc==0:
                    continue
                nr=r+dr
                nc=c+dc
                if 0<=nr<n and 0<=nc<m:
                    if matrix[nr][nc]>=curr:
                        is_strong=False
                        break
            if not is_strong:
                break
        if is_strong:
            strong += 1

print(strong)
        
                   
# 56 92 45
# 19 41 51
# 55 31 80