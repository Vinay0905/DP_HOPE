# 🖥️ Operating Systems (OS) & Memory Management Guide

This guide covers core Operating Systems questions from the reference PDF, customized with questions from your past interview logs (`experiences.txt`) and topics relevant to **MulticoreWare**.

---

## 1. Threading, Scheduling & Resource Management

### Q1. Deadlock vs. Starvation (With Real-World Examples)
*   **Deadlock (Dead-end):** A state where a set of processes are blocked because each process is holding a resource and waiting for another resource held by another process in the same set. None of them can progress.
    *   *Real-World Example*: A narrow one-lane bridge. Two cars drive onto the bridge from opposite ends and meet in the middle. Neither can move forward without the other backing up, but neither wants to back up. They are stuck forever.
    *   *Conditions (Coffman Conditions)*: Mutual exclusion, Hold and wait, No preemption, Circular wait.
*   **Starvation (Perpetual Waiting):** A process is ready to run but is indefinitely delayed because other processes are continuously given higher priority.
    *   *Real-World Example*: A busy restaurant where people with premium VIP memberships (high priority) keep arriving. A walk-in customer (low priority) is continually pushed to the back of the queue and never gets a table. The walk-in customer "starves".
*   **Key Difference:** In deadlock, processes are mutually blocking each other (no one moves). In starvation, the system is running other processes, but one specific low-priority process is starved of CPU time.

### Q2. What is Multithreading, and why is it useful?
*   **Definition:** A thread is a lightweight unit of execution within a process. A single process can have multiple threads sharing the same code segment, data segment, and OS resources, but having their own stack and registers.
*   **Benefits:**
    1.  *Responsiveness*: A user interface thread can remain active while a background thread downloads a file.
    2.  *Resource Sharing*: Threads share the memory of their process, which is much faster than inter-process communication (IPC).
    3.  *Economy*: Creating and switching threads is much cheaper than creating and switching processes (saving context-switch overhead).
    4.  *Scalability*: Can run parallel threads across multiple CPU cores.

---

## 2. Memory Management (Critical for C/C++ Developers)

### Q3. `malloc()` vs. `calloc()` in C
| Feature | `malloc()` | `calloc()` |
| :--- | :--- | :--- |
| **Arguments** | Takes 1 argument: total bytes to allocate. <br>`int* p = malloc(10 * sizeof(int));` | Takes 2 arguments: number of elements and size of each. <br>`int* p = calloc(10, sizeof(int));` |
| **Initialization** | Does **not** initialize memory. The memory contains random "garbage" values. | Initializes all allocated bytes to **zero**. |
| **Speed** | Faster (no overhead of clearing memory). | Slightly slower (has to write zeros to the allocated memory). |

### Q4. Stack vs. Heap Memory Allocation
*   **Stack Allocation:** Used for local variables and function call parameters.
    *   *How it works*: Managed automatically by the CPU using a LIFO (Last-In, First-Out) stack structure.
    *   *Pros/Cons*: Very fast access, no manual deallocation needed, but limited size (can cause Stack Overflow) and variables only exist while the function is running.
*   **Heap Allocation:** Used for dynamic memory allocation at runtime.
    *   *How it works*: Managed manually by the programmer using `new`/`malloc` and `delete`/`free`.
    *   *Pros/Cons*: Large storage capacity, variables can persist across functions, but slower access, and prone to **memory leaks** if not freed.

### Q5. What is a Dangling Pointer, and how does it differ from a Wild Pointer?
*   **Wild Pointer:** A pointer that has been declared but not initialized to anything (not even `NULL`). It points to some random, arbitrary memory address.
    ```cpp
    int* ptr; // Wild pointer
    ```
*   **Dangling Pointer:** A pointer that used to point to a valid memory location, but that memory has now been deleted or freed. If you dereference it, the program may crash or corrupt data.
    ```cpp
    int* ptr = (int*)malloc(sizeof(int));
    free(ptr); // ptr is now a dangling pointer!
    ```
    *   *Fix*: Always set pointers to `nullptr` immediately after freeing them.

### Q6. What is Demand Paging and Thrashing?
*   **Demand Paging:** A virtual memory technique where pages of a program are loaded into physical RAM only when they are actively needed by the CPU (on-demand), rather than loading the whole program at startup. If a page isn't in RAM, a **page fault** occurs, and the OS fetches it from the disk.
*   **Thrashing:** A critical state where the OS spends more time swapping pages in and out of disk than executing actual user instructions. This happens when the active processes require more physical memory than is available, causing continuous page faults.

---

## 3. Data Structures & OS Conditions

### Q7. What is the Overflow Condition of a Circular Queue?
*   In a circular queue of size `N`, we use a circular array where elements wrap around using modulo arithmetic. Let `front` point to the index where elements are deleted, and `rear` point to the index where new elements are inserted.
*   **Overflow Condition:** The queue is full when the next position after `rear` is `front`.
    $$\text{Condition: } (rear + 1) \% N == front$$
*   **Underflow Condition (Empty):** The queue is empty when both front and rear point to `-1` (or `front == rear`).
