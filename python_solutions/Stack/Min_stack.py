class MinStack:

    def __init__(self):
        self.stack=[]


    def push(self, val: int) -> None:
        
        if not self.stack:
            curr_min=val
            
        else:
            curr_min=min(val,self.stack[-1][1])
        self.stack.append((val,curr_min))
        

    def pop(self) -> None:
        if self.stack:
            self.stack.pop()
            
    def top(self) -> int:
        if self.stack:
            return self.stack[-1][0]
        else :
            return None    
    def getMin(self) -> int:
        
        if self.stack:
            return self.stack[-1][-1]
        else:
            return None