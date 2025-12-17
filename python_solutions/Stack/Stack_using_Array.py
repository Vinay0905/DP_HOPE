class Array_stack:
    def __init__(self,size=1000):
        self.arr=[0]*size
        self.capacity=size
        self.top=-1
        
    def push(self,item):
        if self.top>=self.capacity-1:
            print("stack Overflow")
            return 
        
        self.top+=1
        self.arr[self.top]=item
    
    
    
    def pop(self):
        if self.isEmpty():
            print("Stack is empty")
            return -1
        
        top_element=self.arr[self.top]
        self.top-=1
        return top_element
    
    def topp(self):
        if self.isEmpty():
            print("stack is empty")
            return -1
        
        return self.arr[self.top]
    
    def isEmpty(self):
        return self.top == -1

            
if __name__ == "__main__":
    stack = Array_stack()
    commands = ["ArrayStack", "push", "push", "top", "pop", "isEmpty"]
    inputs = [[], [5], [10], [], [], []]

    for i in range(len(commands)):
        if commands[i] == "push":
            stack.push(inputs[i][0])
            print("null", end=" ")
        elif commands[i] == "pop":
            print(stack.pop(), end=" ")
        elif commands[i] == "top":
            print(stack.topp(), end=" ")
        elif commands[i] == "isEmpty":
            print("true" if stack.isEmpty() else "false", end=" ")
        elif commands[i] == "ArrayStack":
            print("null", end=" ")
    
        

        