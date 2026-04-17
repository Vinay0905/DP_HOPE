def placing(n,m)->int:
    
    occupied=set()
    blocks=0
    for _ in range(m):
        x,y=map(int,input().split())
        cells=[
            (x,y),
            (x,y+1),
            (x+1,y),
            (x+1,y+1)
        ]
        can_place=True
        for cell in cells:
            if cell in occupied:
                can_place=False
                break
            
        if can_place:
            for cell in cells:
                occupied.add(cell)
                
            blocks+=1
    return blocks
    
    
    
N, M = map(int, input().split())
print(placing(N, M))