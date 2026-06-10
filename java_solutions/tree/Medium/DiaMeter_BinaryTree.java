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



public class DiaMeter_BinaryTree {
    

    static int diameter=0;
    public static int getHeight(Node root){
        if(root==null)return 0;
        int lh=getHeight(root.left);
        int rh=getHeight(root.right);
        diameter=Math.max(diameter,lh+rh);
        return 1+Math.max(lh,rh);
    }

    public static int diameterOfBinaryTree(Node root) {
        getHeight(root);
        return diameter;
        
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        // Calculate the diameter of the binary tree
        int diameter = diameterOfBinaryTree(root);

        System.out.println("The diameter of the binary tree is: " + diameter);
    }

}
