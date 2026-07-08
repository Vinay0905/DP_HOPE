package Practice.LinkedList.medium;



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



public class addNumbertoLinkedList {
    

    public static Node append(Node head,int val){
        Node newNode=new Node(val);
        if(head==null)return newNode;
        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
        return head;
    }
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }
    public static Node reverse(Node node){
        Node prev =null;
        Node curr=node;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;


    }   
    public static Node bruteforce(Node head){
            head=reverse(head);
            Node temp=head;
            int carry=1;
            while(temp!=null){
                temp.data=temp.data+carry;
                if(temp.data<10){
                    carry=0;
                    break;
                }
                else{
                    temp.data=0;
                    carry=1;
                }
                temp=temp.next;
            }
            if(carry==1){
                Node newNode=new Node(1);
                head=reverse(head);
                newNode.next=head;
                return newNode;
            }
            head=reverse(head);
            return head;

    }

    public static int helper(Node temp){
        if(temp==null)return 1;
        int carry=helper(temp.next);
        temp.data=temp.data+carry;
        if(temp.data<10)return 0;
        temp.data=0;
        return 1;
    }

    public static Node optimalrecursive(Node head){
        int carry= helper(head);
        if(carry==1){
            Node newNode=new Node(1);
            newNode.next=head;
            return newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        

        // Example: Number 129 (1 -> 2 -> 9)
        head = append(head, 1);
        head = append(head, 2);
        head = append(head, 9);

        System.out.print("Original Number: ");
        printList(head);

        head = bruteforce(head);

        System.out.print("After Adding One: ");
        printList(head);
       }
}
