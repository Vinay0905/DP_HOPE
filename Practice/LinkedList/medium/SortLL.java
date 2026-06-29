package Practice.LinkedList.medium;


import java.util.ArrayList;

import java.util.Collections;

class Node{
    int data;
    Node next;
    Node(int data) {
        this.data=data;
        this.next=null;
    }
}





public class SortLL {



    public static Node bruteforce(Node head){
        ArrayList<Integer> arr= new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            arr.add(temp.data);
            temp=temp.next;

        }
        Collections.sort(arr);
        int i=0;temp=head;
        while(temp!=null){
            temp.data=arr.get(i);
            i++;
            temp=temp.next;
        }
        return head;


    }
    // public static void mergersort(int[] arr,int l,int h){
    //     if(l==h)    {
    //         return ;
    //     }
    //     int m=(l+h)/2;
    //     mergersort(arr, l, m);
    //     mergersort(arr, m+1, h);

    // }

    public Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
        // Create a dummy node
        Node dummyNode = new Node(-1);

        // Temp pointer to build merged list
        Node temp = dummyNode;

        // Traverse both lists
        while (list1 != null && list2 != null) {
            // Choose smaller node
            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            // Move temp pointer
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        // Return head of merged list
        return dummyNode.next;
    }

    // Function to find middle of linked list
    public Node findMiddle(Node head) {
        // If list empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Slow and fast pointers
        Node slow = head;
        Node fast = head.next;

        // Move fast twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Return middle node
        return slow;
    }

    // Function to perform merge sort
    public Node sortLL(Node head) {
        // Base case: empty or single node
        if (head == null || head.next == null) {
            return head;
        }

        // Find middle node
        Node middle = findMiddle(head);

        // Split into two halves
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        // Recursively sort both halves
        left = sortLL(left);
        right = sortLL(right);

        // Merge sorted halves
        return mergeTwoSortedLinkedLists(left, right);
    }
    
    static void printLinkedList(Node head) {
        // Pointer to traverse list
        Node temp = head;

        // Traverse and print values
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create linked list: 3 -> 2 -> 5 -> 4 -> 1
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(5);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(1);

        // Print original list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Create Solution object
        

        // Sort the linked list
        head = bruteforce(head);

        // Print sorted list
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }
}
