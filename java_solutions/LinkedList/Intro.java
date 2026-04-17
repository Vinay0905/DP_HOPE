package java_solutions.LinkedList;

/*
BASIC STRUCTURE OF THIS FILE

1) Node class
   - data : stores value
   - next : points to next node

2) Build operations
   - append(head, value)         : insert at end
   - prepend(head, value)        : insert at start
   - insertAtPosition(head, v, p): insert at given position

3) Delete operations
   - deleteHead(head)
   - deleteTail(head)
   - deleteAtPosition(head, p)
   - deleteByValue(head, value)

4) Utility operations
   - printList(head)
   - length(head)
   - search(head, key)
   - reverse(head)
   - findMiddle(head)
   - nthFromEnd(head, n)

5) main method flow
   - create list
   - run insertion operations
   - run deletion operations
   - run utility operations

NOTE
   - all changing operations return updated head
   - if position/value is invalid, list stays safe
*/
public class Intro {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private static Node append(Node head, int value){
        Node newNode = new Node(value);
        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    private static Node prepend(Node head, int value){
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    private static Node insertAtPosition(Node head, int value, int position){
        if (position <= 1 || head == null){
            return prepend(head, value);
        }

        Node temp = head;
        int index = 1;
        while (temp.next != null && index < position - 1){
            temp = temp.next;
            index++;
        }

        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    private static Node deleteHead(Node head){
        if (head == null) return null;
        return head.next;
    }

    private static Node deleteTail(Node head){
        if (head == null || head.next == null) return null;

        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node deleteAtPosition(Node head, int position){
        if (head == null) return null;
        if (position <= 1) return deleteHead(head);

        Node temp = head;
        int index = 1;
        while (temp.next != null && index < position - 1){
            temp = temp.next;
            index++;
        }

        if (temp.next != null){
            temp.next = temp.next.next;
        }
        return head;
    }

    private static Node deleteByValue(Node head, int value){
        if (head == null) return null;
        if (head.data == value) return head.next;

        Node temp = head;
        while (temp.next != null && temp.next.data != value){
            temp = temp.next;
        }

        if (temp.next != null){
            temp.next = temp.next.next;
        }
        return head;
    }

    private static int length(Node head){
        int count = 0;
        Node temp = head;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    private static boolean search(Node head, int key){
        Node temp = head;
        while (temp != null){
            if (temp.data == key) return true;
            temp = temp.next;
        }
        return false;
    }

    private static Node reverse(Node head){
        Node prev = null;
        Node curr = head;
        while (curr != null){
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private static Integer findMiddle(Node head){
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    private static Integer nthFromEnd(Node head, int n){
        if (head == null || n <= 0) return null;

        Node first = head;
        Node second = head;

        for (int i = 0; i < n; i++){
            if (first == null) return null;
            first = first.next;
        }

        while (first != null){
            first = first.next;
            second = second.next;
        }
        return second.data;
    }

    private static void printList(Node head){
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;

        head = append(head, 10);
        head = append(head, 20);
        head = append(head, 30);
        head = prepend(head, 5);
        head = insertAtPosition(head, 15, 3);
        printList(head);

        head = deleteHead(head);
        head = deleteTail(head);
        head = deleteAtPosition(head, 2);
        head = deleteByValue(head, 100);
        printList(head);

        System.out.println(length(head));
        System.out.println(search(head, 20));
        System.out.println(search(head, 99));
        System.out.println(findMiddle(head));
        System.out.println(nthFromEnd(head, 1));

        head = reverse(head);
        printList(head);
    }
}
