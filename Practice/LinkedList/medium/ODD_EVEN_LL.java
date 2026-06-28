package Practice.LinkedList.medium;

import java.util.ArrayList;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data) {
        this.data=data;
        this.next=null;
    }
}


public class ODD_EVEN_LL {
    

    public static ListNode bruteforce(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            arr.add(temp.data);
            temp = temp.next;
        }

        temp = head;
        // int index = 0;

        for (int i = 0; i < arr.size(); i += 2) {
            temp.data = arr.get(i);
            temp = temp.next;
        }

        for (int i = 1; i < arr.size(); i += 2) {
            temp.data = arr.get(i);
            temp = temp.next;
        }

        return head;
    }

    public static ListNode optimal(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = optimal(head);

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
