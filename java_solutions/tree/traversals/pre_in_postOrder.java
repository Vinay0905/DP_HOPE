package java_solutions.tree.traversals;

public class pre_in_postOrder {

    private static class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.key);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);
        System.out.println(node.key);
        inOrderTraversal(node.right);
    }

    void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.key);
    }

    public static void main(String[] args) {
        pre_in_postOrder tree = new pre_in_postOrder();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder traversal of binary tree is");
        tree.preOrderTraversal(tree.root);

        System.out.println("Inorder traversal of binary tree is");
        tree.inOrderTraversal(tree.root);

        System.out.println("Postorder traversal of binary tree is");
        tree.postOrderTraversal(tree.root);
    }
}
