package Practice.LinkedList.medium;


import java.util.HashSet;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data){
        this.data=data;
        this.next=null;
    }
}


public class DetectLoop {
    

    public static boolean bruteforce(ListNode head){
        HashSet<ListNode> visited = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (visited.contains(temp)) {
                return true;
            }

            visited.add(temp);
            temp = temp.next;
        }
        return false;
    }

    public static boolean optimal(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Create a loop: 5 -> 3
        head.next.next.next.next.next = head.next.next;

        if (bruteforce(head)) {
            System.out.println("Loop detected");
        } else {
            System.out.println("No loop detected");
        }
    }
}
