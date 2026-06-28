package Practice.LinkedList.medium;

import java.util.Arrays;
import java.util.List;



class ListNode{
    int data;
    ListNode next;
    ListNode(int data) {
        this.data=data;
        this.next=null;
    }
}

public class deletenthtermInLL {


    public static int lengthofLL(ListNode head){
        int cnt=0;
        while(head!=null){
            cnt++;
            head=head.next;

        }
        return cnt;
    }
    public static ListNode bruteforce(ListNode head,int N){
        int cnt=0;
        ListNode temp=head;
        cnt=lengthofLL(head);
        if(head==null) return null;
        if(N>cnt) return head;
        if(cnt==N){
            ListNode newHead=head.next;
            return newHead;
        }
        int res=cnt-N;
        temp=head;
        while(temp!=null){
            res--;
            if(res==0){
                break;
            }
            temp=temp.next;
        }
        if(temp==null || temp.next==null){
            return head;
        }
        ListNode del=temp.next;
        temp.next=del.next;
        del.next=null;
        return head;

    }


    public static ListNode optimalSol(ListNode head,int N){
        if(head==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<N;i++){
            if (fast == null) {   // N > length of LinkedList
                return head;
            }
            fast=fast.next;
        }
        if (fast == null) {

        return head.next;

    }
        while (fast.next!=null) {
            slow=slow.next;
            fast=fast.next;


        }
        ListNode dummy=slow.next;
        dummy.next=null;
        slow.next=slow.next.next;
        return head;
        
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        // Create linked list manually
        ListNode head = new ListNode(arr.get(0));
        head.next = new ListNode(arr.get(1));
        head.next.next = new ListNode(arr.get(2));
        head.next.next.next = new ListNode(arr.get(3));
        head.next.next.next.next = new ListNode(arr.get(4));

        // Create Solution object


        // Delete the Nth ListNode from the end
        head = bruteforce(head, N);

        // Print the modified linked list
        printLL(head);
    }    


    public static void printLL(ListNode head){
        while(head!=null){
            System.out.print(head.data);
            if(head.next!=null){
                System.out.print(" -> ");
            }
            head=head.next;
        }
        System.out.println();
    }
}
