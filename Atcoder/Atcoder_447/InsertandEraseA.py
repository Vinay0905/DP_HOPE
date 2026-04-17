# s=input()
# t=input()
# s_none=[c for c in s if c!='A']
# t_none=[c for c in t if c!='A']
# if s_none!=t_none:
#     print(-1)
# else:
#     def count_a(s):
#         seg,cnt=[],0
#         for c in s:
#             if c=='A':
                
#                 cnt+=1
#             else:
#                 if cnt>0:
#                     seg.append(cnt)
#                     cnt=0
#         seg.append(cnt)
#         return seg
    
#     s_seg=count_a(s_none)
#     t_seg=count_a(t_none)
#     print(sum(abs(a - b) for a, b in zip(s_seg, t_seg)))







s=input()
t=input()


def parse(string):
    non_a=[]
    a_c=[]
    curr=0
    
    for char in string:
        if char == 'A':
            curr += 1
        else:
            a_c.append(curr)
            non_a.append(char)
            curr = 0
    

    a_c.append(curr)
    
    return non_a, a_c

s_char,s_count=parse(s)
t_char,t_count=parse(t)


if s_char!=t_char:
    print("-1")
else:
    
    ans=sum(abs(sc - tc) for sc, tc in zip(s_count, t_count))
    print(ans)
