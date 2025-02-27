import java.util.*;

class node {
    int data;
    int prio;
    node next, prev;

    node(int d, int p) {
        data = d;
        prio = p;
        next = prev = null;
    }
}

class PriorityQueue {
    node front = null;
    node rear = null;

    void insert(int d, int p) {
        node newn = new node(d, p);
        if (front == null) {
            front = rear = newn;
        } else if (p <= front.prio) {
            newn.next = front;
            front.prev = newn;
            front = newn;
        } else {
            node temp = front;
            while (temp.next != null && temp.next.prio <= p) {
                temp = temp.next;
            }
            if (temp.next == null) {
                temp.next = newn;
                newn.prev = temp;
                rear = newn;
            } else {
                newn.next = temp.next;
                temp.next.prev = newn;
                newn.prev = temp;
                temp.next = newn;
            }
        }
    }

    void display() {
        node temp = front;
        while (temp != null) {
            System.out.println(temp.data + " " + temp.prio);
            temp = temp.next;
        }
    }
}

class Main {
    public static void main(String yamuna[]) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue q = new PriorityQueue(); 

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            q.insert(sc.nextInt(), sc.nextInt()); 
        }

        q.display(); 
        sc.close();
    }
}
