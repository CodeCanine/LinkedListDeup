import java.util.HashSet;
import java.util.Set;

public class Dedup {

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }

    private void deleteDuplicates(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Set<Integer> set = new HashSet<>();
        Node p = head;
        System.out.println("Original");
        printLinkedList(head);

        System.out.println("\n\nNew");
        while (p != null) {
            if (!set.contains(p.val)) {
                set.add(p.val);
                p = p.next;
            } else {
                Node p2 = head;
                while (p2.next != p) {
                    p2 = p2.next;
                }
                p2.next = p.next;
                p = p2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(11);
        head.next.next = new Node(12);
        head.next.next.next = new Node(21);
        head.next.next.next.next = new Node(41);
        head.next.next.next.next.next = new Node(43);
        head.next.next.next.next.next.next = new Node(21);

        Dedup d = new Dedup();
        d.deleteDuplicates(head);
        d.printLinkedList(head);
    }
}



