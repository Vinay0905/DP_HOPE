package Practice.LinkedList.medium;


class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
        this.next=null;
    }
}


public class middleofLinkedList {
    
    public static ListNode bruteforce(ListNode head) {
        ListNode temp = head;
        int cnt = 0;

        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        int mid = cnt / 2;

        temp = head;
        while (mid > 0) {
            temp = temp.next;
            mid--;
        }

        return temp;
    }

    public static ListNode bestSolu(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Find the middle node
        // ListNode middleNode = bruteforce(head);
        ListNode middleNode = bestSolu(head);
        // Display the value of the middle node
        System.out.println("The middle node value is: " + middleNode.data);
    }
}
