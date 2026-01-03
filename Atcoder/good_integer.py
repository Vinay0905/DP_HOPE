# def good_integer(n):
#     count=0
#     number1=1
#     # while number1*number1<n:
#     #     number2=number1+1
#     #     while (number1*number1)+(number2*number2)<=n:
#     #         if (number1*number1)+(number2*number2)==n:
#     #             count+=1
#     #             if count>1:   
#     #                 return False
#     #         number2+=1
#     #     number1+=1
#     # return count==1
#     while number1*number1<n:
#         number2_squared=n-number1*number1
#         number2 = int(number2_squared**0.5)
#         if number2*number2==number2_squared and number2>number1:
#             count+=1
#             if count>1:
#                 return False
#         number1+=1
#     return count==1
# N = int(input())
# answer = []
# i = 1
# while i <= N:
#     if good_integer(i):
#         answer.append(i)
#     i += 1
# print(len(answer))
# if answer:
#     print(*answer)



## time limit for the above code has exceeded  so newer approch 


# N = int(input())
# count={}
# limit=int(N ** 0.5) + 1
# number1=1
# while number1<=limit:
#     number2=number1+1
#     while number2<=limit:
#         total=number1*number1+number2*number2
#         if total>N:
#             break
#         if total not in count:
#             count[total]=0
#         count[total]+=1
#         number2+=1
#     number1+=1

# answer=[]
# for num in sorted(count.keys()):
#     if count[num]==1:
#         answer.append(num)

# print(len(answer))
# if answer:
#     print(*answer)


### this too has time limmit exceeded 

N=int(input())
count=[0] * (N + 1)
limit=int(N ** 0.5)
x=1
while x<=limit:
    x2=x*x
    y=x+1
    while True:
        total=x2+y*y
        if total>N:
            break
        count[total]+=1
        y+=1
    x+=1

answer=[]
i=1
while i<=N:
    if count[i]==1:
        answer.append(i)
    i+=1

print(len(answer))
if answer:
    print(*answer)


