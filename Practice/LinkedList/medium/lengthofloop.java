package Practice.LinkedList.medium;

import java.util.HashMap;


class ListNode{
    int data;
    ListNode next;
    ListNode(int data) {
        this.data=data;
        this.next=null;
    }
}
public class lengthofloop {
 
    public static int BruteForce(ListNode head){
        HashMap<ListNode,Integer> map=new HashMap<>();
        ListNode temp=head;
        int timer=0;
        while(temp!=null){
            if(map.containsKey(temp)){
                return timer-map.get(temp);
            }
            map.put(temp, timer);
            temp=temp.next;
            timer++;
        }
        return 0;
    }
    public static int optimalSol(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)return findlength(slow,fast);
        }
        return 0;
    }

    public static int findlength(ListNode slow, ListNode fast){
        int cnt=1;
        fast=fast.next;
        while(slow!=fast){
            cnt++;
            fast=fast.next;
            
        }
        return cnt;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        // Linking the nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Creating a loop from fifth to second
        fifth.next = second;

        // Creating a Solution object
        

        // Getting the loop length
        int loopLength = optimalSol(head);

        // Printing the result
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }

}
