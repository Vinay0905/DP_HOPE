def magic_square(n):
    grid=[[0]*n for _ in range(n)]
    
    right=0
    center=n//2
    j=n*n+1
    for k in range(1,j):
        grid[right][center]=k
        next_right=(right-1)%n
        next_center=(center+1)%n
        if grid[next_right][next_center]==0:
            right=next_right
            center=next_center
        else:
            right=(right+1)%n
    for i in range(n):
        for j in range(n):
            print(grid[i][j],end=" ")
        
        print()
magic_square(3)

    