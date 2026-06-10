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


public class MaximumPathSum {
    
    static int maxSum=Integer.MIN_VALUE;

    public static int maxPathSum(Node root){
        dfs(root);
        return maxSum;
    }

    public static int dfs(Node root){
        if(root==null)return 0;
        int l=Math.max(0,dfs(root.left));
        int r=Math.max(0,dfs(root.right));
        maxSum=Math.max(maxSum,l+r+root.val);
        return Math.max(l,r)+root.val;
    }


    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        
        System.out.println(
            "Maximum Path Sum: " +
            maxPathSum(root)
        );
    }
}
