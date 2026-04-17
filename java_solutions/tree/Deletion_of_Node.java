package java_solutions.tree;


class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Tree {
    Node root = null;
  public void display(Node root) {
      if (root != null) {
          display(root.left);
          display(root.right);
          System.out.println(root.data + " ");
      }
  }
}
class BinarySearchTree{
    Node root=null;
    public Node insert(Node root,int val){
        if(root==null){
          Node newNode=new Node(val);
          root=newNode;
          return root;
        }
        if(val<root.data){
          root.left=insert(root.left,val);
        }
        else if(val>root.data){
          root.right=insert(root.right,val);
          
        }
        return root;
    }
    public void createBST(int[] arr){
        for(int n:arr){
          root=insert(root,n);
        }
    }
    
    
    
    public void display(Node root) {
        if (root != null) {
            display(root.left);
            display(root.right);
            System.out.print(root.data + " ");
        }
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node deleteNode(Node root, int key) {
        if(root==null)return null;
        if(key<root.data){
            root.left=deleteNode(root.left,key);
        }
        else if(key>root.data){
            root.right=deleteNode(root.right,key);
        }
        else{
            if(root.left==null)return root.right;
            if(root.right==null)return root.left;
            else{
                if(root.right!=null){
                    Node minNode=findMin(root.right);
                    root.data=minNode.data;
                    root.right=deleteNode(root.right,minNode.data);
                }
                else{
                    Node maxNode=findMax(root.left);
                    root.data=maxNode.data;
                    root.left=deleteNode(root.left,maxNode.data);
                }
            }
        }
        return root;
    }
    private Node findMin( Node node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
     }
    private Node findMax(Node node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }
}
