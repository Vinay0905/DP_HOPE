from queue import Queue

class Stack_as_Queue:
    def __init__(self):
        self.q=Queue()
    def push(self,item):
        s=self.q.qsize()
        self.q.put(item)
        for _ in range(s):
            self.q.put(self.q.get())
    def pop(self):
        n=self.q.queue[0]
        self.q.get()
        return n
    def peek(self):
        return self.q.queue[0]
    def isEmpty(self):
        return self.q.empty()