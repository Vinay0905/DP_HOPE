package java_solutions.LinkedList;

/*
BASIC STRUCTURE OF THIS FILE

1) Node class
   - data  : stores integer value
   - next  : points to next node

2) Insertion methods
   - insertAtHead(head, value)
   - insertAtTail(head, value)
   - insertAtPosition(head, value, position)

3) Deletion methods
   - removeHead(head)
   - removeTail(head)
   - removeAtPosition(head, position)
   - removeByValue(head, value)

4) Utility method
   - printList(head) : prints linked list

5) main method flow
   - create list using insertion
   - print list
   - perform deletions
   - print final list

NOTE
   - every insert/delete method returns updated head
   - if position is invalid, list remains safe
*/
public class DeletionInsetion {
    static class Node{
        int data;
        Node next;
        Node (int data){
            this.data=data;
            this.next=null;
        }
    }

    private static Node insertAtHead(Node head, int value){
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    private static Node insertAtTail(Node head, int value){
        Node newNode = new Node(value);
        if (head == null) return newNode;
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    private static Node insertAtPosition(Node head, int value, int position){
        if (position <= 1 || head == null){
            return insertAtHead(head, value);
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

    private static Node removeHead(Node head){
        if (head == null) return null;
        return head.next;
    }

    private static Node removeTail(Node head){
        if (head == null || head.next == null) return null;
        Node temp = head;
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node removeAtPosition(Node head, int position){
        if (head == null) return null;
        if (position <= 1) return removeHead(head);

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

    private static Node removeByValue(Node head, int value){
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

        head = insertAtHead(head, 30);
        head = insertAtHead(head, 20);
        head = insertAtHead(head, 10);
        head = insertAtTail(head, 40);
        head = insertAtPosition(head, 25, 3);
        printList(head);

        head = removeHead(head);
        head = removeTail(head);
        head = removeAtPosition(head, 2);
        head = removeByValue(head, 25);
        printList(head);
    }
}
