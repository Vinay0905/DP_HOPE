package Practice.LinkedList;




class Node{
    int data;
    Node next;
    Node prev;
    Node (int data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
    Node(int data,Node next,Node prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
}


public class Intro_DoublyLL {
    public static Node convertArr2DLL(int[] arr) {
        // Create the head node with the first element of the array
        Node head = new Node(arr[0]);
        Node prev = head;  // Initialize 'prev' to the head node

        // Traverse the array to create the doubly linked list
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);  // Create a new node
            prev.next = temp;  // Set 'next' of the previous node to the new node
            prev = temp;  // Move 'prev' to the new node
        }

        return head;  // Return the head of the doubly linked list
    }

    public static void print(Node head) {
        
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;  
        }
        System.out.println();  
    }
    
    public static Node InsertAtTail(Node head,int k){
        Node newNode=new Node(k);
        if(head==null)return newNode;
        Node tail=head;
        while (tail.next!=null) {
            tail=tail.next;
            
        }
        tail.next=newNode;
        newNode.prev=tail;
        return head;

    }


    public static void main(String[] args) {
        // Initialize an array of integers
        int[] arr = {12, 5, 8, 7, 4};

        // Convert the array to a doubly linked list
        Node head = convertArr2DLL(arr);

        // Print the initially created doubly linked list
        System.out.println("Doubly Linked List Initially: ");
        print(head);

        // Insert a node with value 10 at the end of the doubly linked list
        System.out.println("\nDoubly Linked List After Inserting at the tail with value 10: ");
        head = InsertAtTail(head, 10);
        print(head);
    }
}
