s=input()
from collections import Counter
c=Counter(s)
max_f=max(c.values())
rem={ch for ch,cnt in  c.items() if cnt==max_f}
print(''.join(ch for ch in s if ch not in rem))