"""
Docstring for Codeforces.Unfair_game
Bob is tired of losing to Alice and, to ensure he doesn't lose again, decided to choose a game in which he is guaranteed to win. Bob has thought of a number from 1
 to n
, where it is known that n=2d
 for some non-negative integer d
. Initially, Alice knows whether the chosen number is even or not.

In one move, Alice can either halve the number or subtract 1
. Alice can only halve the number if the curr number is even. Only Alice takes turns.

After her move, Alice receives a response from Bob: either −1
, which means the number has become 0
 and Alice has won, or a non-negative integer x
. If we denote the curr number as a
, then for x
 the following conditions hold simultaneously:

a
 is divisible by 2x
.
a
 is not divisible by 2x+1
.
For example, if a=5
, then x=0
, since 5
 is divisible by 20=1
 and not divisible by 21=2
, and if a=12
, then x=2
, since 12
 is divisible by 22=4
 and not divisible by 23=8
.

It can be shown that for any integer a>0
, there exists a unique such x
.

Bob is still afraid that Alice will win, so the game will have no more than k
 moves. Additionally, Bob wants to maximize his chances of winning, so he wants to play as many games as possible. Given n
 and k
, calculate the number of initial numbers from 1
 to n
 such that Alice, playing optimally, cannot win in no more than k
 moves.

Input
The first line contains an integer t
 (1≤t≤104)
 — the number of test cases.

The only line of each test case contains 2
 integers n
 and k
 (1≤n,k≤109)
 — the limit on the chosen number and the maximum number of Alice's moves, respectively. It is guaranteed that n=2d
 for some non-negative integer d
.

Output
For each test case, output the number of integers from 1
 to n
 such that Alice, playing optimally, cannot win in at most k
 moves.
"""

import sys 
input=sys.stdin.readline


t=int(input())
for _ in range(t):
    n,k=map(int,input().split())
    d=n.bit_length()-1
    if d==0:
        if k>=1:
            print(0)
        else:
            print(1)
        continue
    max_move=max(2*d-1,d+1)
    if k>=max_move:
        print(0)
        continue
    result=0
    for i in range(d):
            min_pop=k-i+1 
            if min_pop<=1:
                result+=(1<<i)
            elif min_pop>i+1:
                continue
            else:
                lower=min_pop - 1
                if lower<=0:
                    count=1<<i
                elif lower>i:
                    count=0
                else:
                    total=0
                    comb=1
                    for j in range(lower):
                        comb=comb*(i-j)//(j+1)
                    curr=comb
                    for j in range(lower,i+1):
                        if j>lower:
                            curr=curr*(i-j+1)//j
                        total+=curr
                    count=total
                result+=count
    if d+1>k:
            result+=1
            
    print(result)