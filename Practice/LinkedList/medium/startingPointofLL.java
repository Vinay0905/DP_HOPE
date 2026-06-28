package Practice.LinkedList.medium;


import java.util.HashSet;

class ListNode{
    int data;
    ListNode next;
    ListNode(int data) {
        this.data=data;
        this.next=null;
    }
}
public class startingPointofLL {


    public static ListNode bruteforce(ListNode head){
        ListNode temp=head;
        HashSet<ListNode> map=new HashSet<>();
        
        while(temp!=null){
            if(map.contains(temp)){
                return temp;
            }
            else map.add(temp);

            temp=temp.next;
        }
        return null;


    }

    public static ListNode optimalSol(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;

            }
        }
        return null;
        
    }
    public static void main(String[] args) {
        // Creating linked list nodes
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        // Creating a cycle (tail connects to node index 1)
        head.next.next.next.next = head.next;

        
        ListNode startNode = bruteforce(head);
        ListNode startNode1 = optimalSol(head);

        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.data);
        else
            System.out.println("No cycle found.");
        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode1.data);
        else
            System.out.println("No cycle found.");
    }   
}
