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
public class pallindromeLL {
    public static boolean bruteforce(ListNode head)   {
        Stack<Integer> st=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            if(temp.data!=st.peek())return false;
            temp=temp.next;
            st.pop();
        }
        return true;
    }

    public static boolean optimal (ListNode head){
        if(head == null || head.next == null)
            return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        ListNode newHead=reverseLinkedList(slow.next);
        ListNode first=head;
        ListNode second=newHead;
        while(second!=null){
            if(first.data!=second.data){
                reverseLinkedList(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reverseLinkedList(newHead);
        return true;
    }

    public static ListNode reverseLinkedList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode front=curr.next;
            curr.next=prev;
            prev=curr;
            curr=front;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println("Linked List:");
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        System.out.println("Bruteforce: " + bruteforce(head));
        System.out.println("Optimal: " + optimal(head));
    }
}
