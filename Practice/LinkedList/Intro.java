
package Practice.LinkedList;

// ===========================================================
// Node Definition
// ===========================================================
class Node{
    int data;
    Node next;
    Node(int data,Node next1){
        this.data=data;
        this.next=next1;
    }
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
// ===========================================================
// Linked List Operations
// ===========================================================
public class Intro {
    
// ===========================================================
// Insertion Operations
// ===========================================================
    public static Node insertHead(Node head,int newval){
        Node newNode=new Node(newval,head);
        return newNode;
    }
// ===========================================================
// Traversal Operations
// ===========================================================
    public static void printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;

        }
        System.out.println();
    }
    public static int LengthFinder(Node head){
        if (head==null)return 0;
        int counter=0;
        Node temp=head;
        while(temp!=null){
            counter++;
            temp=temp.next;
        }
        return counter;

    }
    public static Node Search(Node head,int target){
        if(head==null){
            return null;

        }
        Node curr=head;
        while(curr!=null){
            if(curr.data==target){
                return curr;
            }
            else{
                curr=curr.next;
            }
        }
        return null;
    }

// ===========================================================
// Deletion Operations
// ===========================================================
    public static Node deletionAtHead(Node head){
        if(head==null){
            return null;

        }
        Node temp=head;
        head=head.next;
        temp.next=null;
        return head;
        
    }
    public static Node deleteAtTail(Node head){
        if(head==null || head.next==null)return null;
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=null;
        return head;
    }
// ===========================================================
// Driver Code
// ===========================================================
    public static void main(String[] args) {

        // ===========================================================
        // Creating Initial Linked List
        // ===========================================================
        // Creating a sample linked list: 2 -> 3
        Node head = new Node(2);
        head.next = new Node(3);

        System.out.println("Original List:");
        printList(head);

        // ===========================================================
        // Testing Insertion at Head
        // ===========================================================
        head = insertHead(head, 1);

        System.out.println("After Insertion at Head:");
        printList(head);

        // ===========================================================
        // Testing Deletion at Head
        // ===========================================================
        head = deletionAtHead(head);

        System.out.println("After Deletion at Head:");
        printList(head);
    }

}
