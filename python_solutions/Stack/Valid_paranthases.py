class Stack:
    def __init__(self):
        self.stack = []
    
    def push(self, item):
        self.stack.append(item)
    
    def pop(self):
        if self.isEmpty():
            return None
        return self.stack.pop()
    
    def isEmpty(self):
        return len(self.stack) == 0
    
    def peek(self):
        return self.stack[-1] if self.stack else None

        
def isValid(s:str):
    stack=Stack()
    
    for i in s:
        if i=='(' or i=='{' or i=='[':
            stack.push(i)
        else:
            if stack.isEmpty():
                return False
            if i==')' and stack.peek()=='(':
                stack.pop()
            elif i=='}' and stack.peek()=='{':
                stack.pop()
            
            elif i==']' and stack.peek()=='[':
                stack.pop()
            else:
                return False    
    
    return stack.isEmpty()
    

s="()[]{}"

print(isValid(s))
        
        
        
        
        
        