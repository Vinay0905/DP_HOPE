package Practice.LinkedList.medium;



class ListNode{
    int data;
    ListNode next;
    ListNode(int data) {
        this.data=data;
        this.next=null;
    }
}


public class deletetheMiddleNode {
    
    public static int lengthofLL(ListNode head){
        int cnt=0;
        while(head!=null){
            cnt++;
            head=head.next;

        }
        return cnt;
    }


    public static ListNode bruteforce(ListNode head ){
        if(head==null || head.next==null) return null;

        int len=lengthofLL(head);
        int mid=len/2;

        ListNode temp=head;
        while(temp!=null){
            mid--;
            if(mid==0){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }


    public static ListNode optimalSol(ListNode head){
        if(head==null || head.next==null) return null;

        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        prev.next=slow.next;
        return head;
    }
    
    public static void printLL(ListNode head){
        while(head!=null){
            System.out.print(head.data + " -> ");
            head=head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);

        System.out.println("Original Linked List:");
        printLL(head);

        head=optimalSol(head);

        System.out.println("After deleting middle node:");
        printLL(head);
    }

}
