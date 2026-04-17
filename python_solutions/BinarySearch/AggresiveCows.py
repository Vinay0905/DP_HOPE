def canPlace(stalls,cows,d):
    c=1
    lasPos=stalls[0]
    for i in range(1,len(stalls)):
        if stalls[i]-lasPos>=d:
            c+=1
            lasPos=stalls[i]
        if c>=cows:
            return True
    return False
def aggresiveCow(stalls,cows):
    stalls.sort()
    l,h=0,stalls[-1]-stalls[0]
    ans=0
    while l<=h:
        m=(l+h)//2
        if canPlace(stalls,cows,m):
            ans=m
            l=m+1
        else:
            h=m-1
    return ans


stalls = [1, 2, 8, 4, 9]
cows = 3

print(aggresiveCow(stalls, cows))