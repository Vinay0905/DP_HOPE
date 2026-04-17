num1,num2=map(int,input().split())
takahasi=set(input().strip())
aoki=set(input().strip())
count=int(input())
for _ in range(count):
    word=input().strip()
    chars=set(word)
    mightBeTake=chars.issubset(takahasi)
    mightBeAoki=chars.issubset(aoki)
    
    if mightBeTake and not mightBeAoki:
        print("Takahashi")
    elif mightBeAoki and not mightBeTake:
        print("Aoki")
    else:
        print("Unknown")
    

        