# AtCoder Beginner Contest 448

This folder contains solutions to problems from AtCoder Beginner Contest 448 (ABC448). I have solved 4 problems: A, B, C, and D.

## Solved Problems

### Problem A: chmin

This problem involves tracking the minimum value in a sequence.
We start with an initial value x and iterate through an array.
For each element, if it's smaller than current x, update x and output 1; otherwise output 0.

### Problem B: Except and Min

The task requires finding the minimum value in a sorted array while excluding certain indices.
We sort the array with their original indices.
For each query, we find the smallest value not in the excluded list among the first k+1 elements.

### Problem C: Integer Duplicated Path

This is a tree traversal problem to detect duplicate integers on paths from the root.
We perform DFS, maintaining a path of values from root to current node.
For each node, check if any value repeats in the current path and output "Yes" or "No".

### Problem D: Pepper Addiction

The problem involves distributing peppers to stations with capacity constraints.
We have demands for each station and capacities.
For each station, we take the minimum of its demand and capacity, summing them up.
