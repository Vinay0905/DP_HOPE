class Queue:
    def __init__(self):
        self.arr=[0]*10
        
        self.start=-1
        self.end=-1
        self.size=0
        self.maxsize=10
    def push(self,item):
        if self.size==self.maxsize:
            print("queue is full")
            exit(1)
            
            
        if self.end==-1:
            self.end=0
            self.start=0
        else:
            self.end=(self.end+1)%self.maxsize
            
        
        self.arr[self.end]=item
        self.size+=1
        
    def pop(self):
        if self.size==0:
            print("queue is empty")
            exit(1)
        popped=self.arr[self.start]
        if self.start==self.end:
            self.start=-1
            self.end=-1
        else:
            self.start=(self.start+1)%self.maxsize
            
        self.size-=1
        return popped


    def peek(self):
        if self.size==0:
            print("queue is empty")
            exit(1)
    
        return self.arr[self.start]
            
            
    def isEmpty(self):
        return self.size==0
    
    


if __name__ == "__main__":
    queue = Queue()
    commands = ["ArrayQueue", "push", "push", "peek", "pop", "isEmpty"]
    inputs = [[], [5], [10], [], [], []]

    for i in range(len(commands)):
        if commands[i] == "push":
            queue.push(inputs[i][0])
            print("null", end=" ")
        elif commands[i] == "pop":
            print(queue.pop(), end=" ")
        elif commands[i] == "peek":
            print(queue.peek(), end=" ")
        elif commands[i] == "isEmpty":
            print("true" if queue.isEmpty() else "false", end=" ")
        elif commands[i] == "ArrayQueue":
            print("null", end=" ")