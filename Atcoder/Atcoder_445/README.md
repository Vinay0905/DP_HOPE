# AtCoder Beginner Contest 445 – 14-02-26

## 01 Strong Word

<!-- [Submission Link For Question 1]() -->

```python
s=input().strip()
if s[0]==s[-1]:
    print("Yes")
else:
    print("No")
```

Reason:
Check if the first and last characters of the string are equal.

- If they match, print "Yes"
- Otherwise, print "No"

---

## 02 Center Alignment

<!-- [Submission Link For Question 2]() -->

```python
n=int(input())
s=[input().strip() for _ in range(n)]
m=max(len(x) for x in s)
for a in s:
    k=(m-len(a))//2
    print('.'*k+a+'.'*k)
```

Reason:
Center align strings by padding with dots.

- Find the maximum length among all strings
- For each string, calculate the number of dots needed on the left: `(max_len - current_len) // 2`
- Print dots, the string, and dots again to center it

---

## 03 Sugoroku Destination

<!-- [Submission Link For Question 3]() -->

```python
n=int(input())
A=[0]+list(map(int, input().split()))
ans=[0]*(n+1)
for i in range(n,0,-1):
    ans[i] = i if A[i]==i else ans[A[i]]
print(" ".join(map(str,ans[1:])))
```

Reason:
Simulate a Sugoroku (Japanese board game) where each position has a destination.

- Work backwards from position n to 1
- For each position i: if A[i] == i, the destination is i itself (we stay), otherwise follow the chain to A[i]
- ans[i] stores the final destination from position i
- Print the destinations for positions 1 to n
