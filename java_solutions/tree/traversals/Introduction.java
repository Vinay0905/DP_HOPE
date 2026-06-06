package java_solutions.tree.traversals;



class Node{
    int key;
    Node left,right;
    public Node(int item){
        key=item;
        left=right=null;
    }
}



public class Introduction {
    
    public static Node BinaryTree(){
        Node root =new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.right.left=new Node(5);
        return root;
    }
    public static void main(String[] args) {
        Node root=BinaryTree();
        System.out.println(root);
    }
}

