package Practice.LinkedList.medium;



class Node {
    int val;
    Node next;
    Node(){}
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
public class addTwoNumbers {

    // public static Node addNode(Node head, int val) {
    //     Node newNode = new Node(val);
    //     if (head == null) {
    //         return newNode;
    //     }
    //     Node temp = head;
    //     while (temp.next != null) {
    //         temp = temp.next;
    //     }
    //     temp.next = newNode;
    //     return head;
    // }


    public static Node approch(Node l1,Node l2){
        Node dummy=new Node();
        Node temp=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=0;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            sum+=carry;
            carry=sum/10;
            Node node=new Node(sum%10);
            temp.next=node;
            temp=temp.next;

        }
        return dummy.next;
    }

    public static Node createList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num1 = {2, 4, 3}; // represents 342
        int[] num2 = {5, 6, 4}; // represents 465
        Node l1 = createList(num1);
        Node l2 = createList(num2);

        
        Node result = approch(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }

}
