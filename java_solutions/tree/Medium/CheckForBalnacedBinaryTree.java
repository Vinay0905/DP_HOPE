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

public class CheckForBalnacedBinaryTree {
    
    public static int getHeight(Node root){
        if(root==null)return 0; 
        int leftHiehgt=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        return Math.max(leftHiehgt,rightHeight)+1;
    }

    public static boolean bruteforce(Node root) {
        if(root==null)return true; 
        int leftHiehgt=getHeight(root.left);
        int rightHeight=getHeight(root.right);
        if(Math.abs(leftHiehgt-rightHeight)<=1 && bruteforce(root.left) && bruteforce(root.right))return true;
        return false;

    }
    public boolean optimalSolution(Node root) {

        return height(root) != -1;

    }

    private int height(Node root) {

        if (root == null) {

            return 0;

        }

        int l = height(root.left);

        if (l == -1) {

            return -1;

        }

        int r = height(root.right);

        if (r == -1) {

            return -1;

        }

        if (Math.abs(l - r) > 1) {

            return -1;

        }

        return Math.max(l, r) + 1;

    }
    public static void main(String[] args) {
        
    }

}
