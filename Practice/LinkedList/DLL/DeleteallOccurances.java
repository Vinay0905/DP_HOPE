package Practice.LinkedList.DLL;



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
public class DeleteallOccurances {
    


    public static void insertAtEnd(Node[] head,int val){
        Node newNode=new Node(val);
        if(head[0]==null){
            head[0]=newNode;
            return ;
        }
        Node temp=head[0];

        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        newNode.prev=temp;
    }

    public static  void printList(Node head) {
        // Start from the head node
        Node temp = head;

        // Traverse and print each node's data
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node deleteTargetNodes(Node head,int tar ) {
        
    }



    public static void main(String[] args) {
        
        Node[] headRef = new Node[1];

        // Insert sample values into the list
        insertAtEnd(headRef, 1);
        insertAtEnd(headRef, 2);
        insertAtEnd(headRef, 3);
        insertAtEnd(headRef, 2);
        insertAtEnd(headRef, 4);
        insertAtEnd(headRef, 2);
        insertAtEnd(headRef, 5);

        // Print the original list
        System.out.println("Original List:");
        printList(headRef[0]);

        // Delete all nodes with value 2
        int target = 2;
        headRef[0] = deleteTargetNodes(headRef[0], target);

        // Print the updated list
        System.out.println("\nList after deleting value " + target + ":");
        printList(headRef[0]);
    }
}
