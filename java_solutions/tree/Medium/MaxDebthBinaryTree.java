package java_solutions.tree.Medium;



class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}




public class MaxDebthBinaryTree {

    public static int maxdebth(Node root){
        if(root==null)return 0;
        int leftHiehgt=maxdebth(root.left);
        int rightHeight=maxdebth(root.right);
        return 1+Math.max(leftHiehgt,rightHeight);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        
        int depth = maxdebth(root);

        System.out.println("Maximum depth of the binary tree: " + depth);
    }
}
