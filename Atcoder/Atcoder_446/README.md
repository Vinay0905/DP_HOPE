# Atcoder 446 Solutions

## 1. GreedyDraft.py

**Problem**: Greedy item allocation where n people have wishlists of items, but each item can only be given once.

- Uses a greedy approach to assign each person their first available (untaken) item from their wishlist.
- Maintains a boolean array to track which items have been taken to avoid duplicate allocations.
- Processes people sequentially and outputs the assigned item for each person in order.

## 2. Handmaid.py

**Problem**: Simple string transformation that adds a prefix to the input string.

- Reads the input string and converts it to lowercase for processing.
- Prepends the string "Of" to the transformed input.
- Returns the formatted output combining the prefix with the lowercased string.

## 3. MaxStraight.py

**Problem**: Find the longest consecutive sequence of numbers in an array.

- Uses dynamic programming with a dictionary to store the length of consecutive sequences ending at each number.
- For each number x, checks if x-1 exists in the dictionary and extends that sequence length.
- Tracks the maximum sequence length found and outputs the result.

## 4. OmeletteRestaurant.py

**Problem**: Manage restaurant inventory where omelets are made each day and consumed, with a storage limit.

- Simulates T test cases using a deque to manage inventory with FIFO (first-in-first-out) order.
- On each day, adds available omelets and fulfills demand from oldest inventory first, then removes expired items older than d days.
- Calculates and outputs the total remaining inventory after all operations for each test case.
