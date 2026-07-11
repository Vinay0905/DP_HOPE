import java.util.Stack;

class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
    // Node(){
    //     this.val=0;
    //     this.next=null;
    // }
}


public class round2_linkedList {
    

    Node  head;
    public static Node insert(Node head,int val){
        Node newNode=new Node(val);
        if(head==null)
            head=newNode;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        return head;

    }

    public static void printll(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(" "+temp.val +" -> ");
            temp=temp.next;

        }
        System.out.println();
        
    }
    public static Node reverseBruteForce(Node head){
        Stack<Integer> st=new Stack<>();
        Node temp=head;
        while(temp!=null){
            st.add(temp.val);
            temp=temp.next;

        }
        temp=head;
        while(temp!=null){
            temp.val=st.pop();
            temp=temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        Node ll=new Node(1);
        

        insert(ll, 2);
        insert(ll, 3);
        insert(ll, 4);
        System.out.println(ll);
        printll(ll);
        reverseBruteForce(ll);
        printll(ll);
        
    }
}
