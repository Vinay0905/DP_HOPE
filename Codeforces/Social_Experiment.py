# t=int(input())
# for _ in range(t):
#     num=int(input())
#     remainda =num%4
#     if remainda==0:
#         print(0)
#     elif remainda==2:
#         print(2)
#     else:
#         print(1)
import sys

input=sys.stdin.readline

t=int(input())
for _ in range(t):
    numb=int(input())
    
    if numb==2:
        print(2)
    elif numb==3:
        print(3)
    elif numb%2==0:
        print(0)
    else:
        print(1)
