# 2. Given a Boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 then make its adjacent cells as 0.
# Input:
# 1 0 1
# 0 1 0
# 1 1 1
# Output:
# 0 0 0
# 0 0 0
# 1 0 1
# Explanation:
# For the cell mat[0][0] which is 1, its adjacent cells (mat[0][1] and mat[1][0]) are modified to 0.
# For the cell mat[1][1] which is 1, its adjacent cells (mat[0][1], mat[1][0], mat[1][2], and mat[2][1]) are modified to 0.
# The modification is not applied to the cell mat[2][2] as it doesn't have all four adjacent cells.


def adjacent_cell_change(mat):
    m=len(mat)
    n=len(mat[0])
    
    temp = [row[:] for row in mat]

    # directions = [
    # (-1, -1), (-1, 0), (-1, 1),
    # (0, -1),           (0, 1),
    # (1, -1),  (1, 0),  (1, 1)
    #     ]
    
    directions = [
        (-1, 0),
        (1, 0),
        (0, -1),
        (0, 1)
    ]
    
    for i in range(m):
        for j in range(n):
            # If current cell is 1 in original matrix
            if mat[i][j] == 1:
                # Modify all adjacent cells in result matrix
                for di, dj in directions:
                    ni, nj = i + di, j + dj
                    # Check if adjacent cell is within bounds
                    if 0 <= ni < m and 0 <= nj < n:
                        temp[ni][nj] = 0
    
    return temp



mat=[
    [1,0,1],
    [0,1,0],
    [1,1,1]
]

res=adjacent_cell_change(mat)
for row1 in res:
    print(*row1)
    

    
    

    
    