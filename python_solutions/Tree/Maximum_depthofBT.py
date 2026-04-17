class Node:
    def __init__(self,value):
        self.value=value
        self.left=None
        self.right=None

class BinaryTree:
    def __init__(self, value=None): 
        if value is None: 
            self.root = None
        else:
            self.root = Node(value)
    
    def insert(self,value):
        new_node=Node(value)
        if self.root==None : 
            self.root=new_node
            return True
        temp=self.root
        
        while True:
            if new_node.value==temp.value:
                return False
            if new_node.value<temp.value:
                if temp.left is None:
                    temp.left=new_node
                    return True
                temp=temp.left
            else:
                if temp.right is None:
                    temp.right=new_node
                    return True
                temp=temp.right
                
    def contains(self,value):
        
        if self.root==None:
            return False
        temp=self.root
        while temp is not None:
            if value <temp.value:
                temp=temp.left
            
            elif value>temp.value:
                temp=temp.right
            else:
                return True
        
        return False
    
    
    
def max_depth(root):
    if root is None:
        return 0
    ld=max_depth(root.left)
    rd=max_depth(root.right)
    
    return 1+max(ld,rd)