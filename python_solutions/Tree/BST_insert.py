class Node:
    def __init__(self,value):
        self.value=value
        self.left=None
        self.right=None


class BinaryTree:
    def __init__(self, value=None):  # Use default None parameter
        if value is None:              # Use 'is' not '=='
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
                
            
            
        
        

my_tree=BinaryTree()
my_tree.insert(2)
my_tree.insert(1)
my_tree.insert(3)
print(my_tree.root.value)
print(my_tree.root.left.value)
print(my_tree.root.right.value)