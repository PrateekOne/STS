import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
}

class DLL {
    Node head = null;

    void insert(int d) {
        Node newNode = new Node(d);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void segregate() {
        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        Node temp = head;

        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = evenEnd = temp;
                } else {
                    evenEnd.next = temp;
                    temp.prev = evenEnd;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = oddEnd = temp;
                } else {
                    oddEnd.next = temp;
                    temp.prev = oddEnd;
                    oddEnd = oddEnd.next;
                }
            }
            temp = temp.next;
        }

        if (evenStart == null) {
            head = oddStart;
        } else if (oddStart == null) {
            head = evenStart;
            evenEnd.next = null;
        } else {
            evenEnd.next = oddStart;
            oddStart.prev = evenEnd;
            head = evenStart;
            oddEnd.next = null;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL dll = new DLL();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            dll.insert(d);
        }

        dll.segregate();
        dll.display();
    }
}
