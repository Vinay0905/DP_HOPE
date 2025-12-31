class Node:
    def __init__(self,value):
        self.value=value
        self.left=None
        self.right=None


class BinaryTree:
    def __init__(self, value):
        new_node=Node(value)
        self.root=new_node
    
    
    
my_tree=BinaryTree(2)
print(my_tree.root.value)
[]