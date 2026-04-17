def to_minutes(t):
    h, m = map(int, t.split(':'))
    return h * 60 + m

N, M = map(int, input().split())
start_time = input().strip()
start = to_minutes(start_time)

on_time = 0
for _ in range(N):
    arrival = input().strip()
    if to_minutes(arrival) <= start:
        on_time += 1

if on_time < M:
    print("Yes")
else:
    print("No")
