class Queue_as_stack:
    def __init__(self):
        self.s1=[]
        self.s2=[]
        
    def push(self,x):
        self.s1.append(x)

    def pop(self):
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2.pop()
    def peek(self):
        if not self.s2:
            while self.s1:
                self.s2.append(self.s1.pop())
        return self.s2[-1]
    
    
    def isEmpty(self):
        return len(self.stack1) == 0 and len(self.stack2) == 0
    
            

        