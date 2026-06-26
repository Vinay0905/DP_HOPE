package Practice.LinkedList.medium;

import java.util.Stack;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data) {
        this.data=data;
        this.next=null;
    }
}

public class reverseLinkedList {
    
    public static ListNode bruteForce(ListNode head) {
        Stack<Integer> st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            st.add(temp.data);
            temp=temp.next;

        }
        temp=head;
        while(temp!=null){
            temp.data=st.pop();
            temp=temp.next;
        }
        return head;
    }
    public static ListNode optimalSolution(ListNode head) {

        ListNode temp=head;
        ListNode front;
        ListNode prev=null;
        while(temp!=null){
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;

    }
    public static ListNode recursive(ListNode head){
        if(head==null || head.next==null)return head;

        ListNode newNode=recursive(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newNode;

    }
    public static void main(String[] args) {
         ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        
        head = bruteForce(head);
        // ListNode head1=optimalSolution(head);

        // Printing reversed list
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
