from typing import List
from collections import deque
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


### This is the DFS approch(Deepth First Search)
    
def Inorder_traversals(root):
    """
    Left root Right
    """
    if root is None:
        
        return []
    Inorder_traversals(root.left)
    print(root.value)
    Inorder_traversals(root.right)
    

def Preorder_traversals(root):
    """
    Root left right
    """
    if root is None:
        return []
    print(root.value)
    Preorder_traversals(root.left)
    Preorder_traversals(root.right)
    
def Postorder_traversals(root):
    """
    left right root
    """
    if root is None:
        return []
    Postorder_traversals(root.left)
    Postorder_traversals(root.right)
    print(root.value)
    

    
### BFS(Breadth First search)-Level wise 

def level_order_traversal(root):
    ans=[]
    
    if root is None:
        return ans
    
    queue=deque([root])
    while queue:
        level=[]
        for _ in range(len(queue)):
            node=queue.popleft()
            level.append(node.value)
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        ans.append(level)
    
    
    return ans
    
    
                

    