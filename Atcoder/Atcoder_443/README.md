# Denso Create Programming Contest 2026 (AtCoder Beginner Contest 443) – 31-01-26

## Append s

[Submission Link For Question 1](https://drive.google.com/file/d/1bbN66B103b2kEz2ApXIazmWur6oKCeP8/view?usp=drive_link)

```python
t = input().strip()
print(t + "s")
```

Reason:
Simple string concatenation.

---

## Setsubun

[Submission Link For Question 2](https://drive.google.com/file/d/1DbHDioVUs5l7bXTwOGYQ0QdA8E95I70q/view?usp=drive_link)

```python
n, k = map(int, input().split())
l, h = 0, 2 * 10**9
while l < h:
    m = (l + h) // 2
    t = (m + 1) * n + m * (m + 1) // 2
    if t >= k:
        h = m
    else:
        l = m + 1
print(l)
```

Reason:
Binary search on years `x` (range `0` to `2 billion`).
Check if the sum from `N` to `N + x` >= `K`.
Formula: `(x+1)*N + x*(x+1)/2`.

Better way:
Solve using the quadratic equation directly (O(1)), but binary search avoids floating-point precision issues and is fast enough.

---

## Chokutter Addiction

[Submission Link For Question 3](https://drive.google.com/file/d/1nFfQb8dTUKJFh81uGIDUMH1jS7TY717q/view?usp=sharing)

```python
n, t = map(int, input().split())
if n > 0:
    a = list(map(int, input().split()))
else:
    a = []

o_delay = 100
t_view = 0
c_star = 0
i = 0
while i < n:
    ai = a[i]
    if ai < c_star:
        i += 1
        continue
    t_view += ai - c_star
    c_star = ai + o_delay
    i += 1

if c_star < t:
    t_view += t - c_star

print(t_view)
```

Method used:
Treat each viewing period as a time interval `[L, R)` and scan Aoki’s passes in order, updating the open interval each time Takahashi closes and reopens Chokutter (simple greedy / sweep over sorted times).

---

## Pawn Line

[Submission Link For Question 4](https://drive.google.com/file/d/12WJnQMsBnoaJgqeScLTwqARV1rzwAJbi/view?usp=sharing)

```python
t = int(input())
o_l = []

for _ in range(t):
    n = int(input())
    R = list(map(int, input().split()))
    p_f = [0] * n
    p_f[0] = R[0] - 0
    for i in range(1, n):
        p_f[i] = min(p_f[i - 1], R[i] - i)

    sux = [0] * n
    sux[-1] = R[-1] + (n - 1)
    for i in range(n - 2, -1, -1):
        sux[i] = min(sux[i + 1], R[i] + i)

    t_move = 0
    for i in range(n):
        l = i + p_f[i]
        r = sux[i] - i
        f_i = min(l, r)
        t_move += R[i] - f_i

    o_l.append(str(t_move))

print("\n".join(o_l))
```

Method:
Use prefix and suffix arrays to track the best possible “height pattern” from both sides, then combine them to get the final height for each column while ensuring `|x - y| <= 1`.
