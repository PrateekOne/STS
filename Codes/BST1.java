import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int d) { data = d; }
}

class BT {
    Node root, prev, f, m, l;

    Node create() {
        Scanner sc = new Scanner(System.in);
        root = new Node(sc.nextInt());
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (int i = 0; i < 2; i++) {
                int val = sc.nextInt();
                if (val != -1) {
                    Node newNode = new Node(val);
                    if (i == 0) curr.left = newNode;
                    else curr.right = newNode;
                    q.add(newNode);
                }
            }
        }
        return root;
    }

    void recoverBST(Node root) {
        if (root == null) return;
        inorder(root);
        if (f != null) swap(f, (l != null) ? l : m);
    }

    void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && prev.data > root.data) {
            if (f == null) f = prev; else l = root;
            if (f != null && m == null) m = root;
        }
        prev = root;
        inorder(root.right);
    }

    void level(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
}

public class BST1 {
    public static void main(String args[]) {
        BT t = new BT();
        t.root = t.create();
        t.recoverBST(t.root);
        t.level(t.root);
    }
}
// import java.util.*;

// class Node {
//     int data;
//     Node left, right;
//     Node(int d) { data = d; }
// }

// class BT {
//     Node root, prev, f, m, l;

//     Node create() {
//         Scanner sc = new Scanner(System.in);
//         root = new Node(sc.nextInt());
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while (!q.isEmpty()) {
//             Node curr = q.poll();
//             for (int i = 0; i < 2; i++) {
//                 int val = sc.nextInt();
//                 if (val != -1) {
//                     Node newNode = new Node(val);
//                     if (i == 0) curr.left = newNode;
//                     else curr.right = newNode;
//                     q.add(newNode);
//                 }
//             }
//         }
//         return root;
//     }

//     void recoverBST(Node root) {
//         if (root == null) return;
//         inorder(root);
//         if (f != null) swap(f, (l != null) ? l : m);
//     }

//     void inorder(Node root) {
//         if (root == null) return;
//         inorder(root.left);
//         if (prev != null && prev.data > root.data) {
//             if (f == null) f = prev; else l = root;
//             if (f != null && m == null) m = root;
//         }
//         prev = root;
//         inorder(root.right);
//     }

//     void level(Node root) {
//         if (root == null) return;
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);
//         while (!q.isEmpty()) {
//             Node curr = q.poll();
//             System.out.print(curr.data + " ");
//             if (curr.left != null) q.add(curr.left);
//             if (curr.right != null) q.add(curr.right);
//         }
//     }

//     void swap(Node a, Node b) {
//         int temp = a.data;
//         a.data = b.data;
//         b.data = temp;
//     }
// }

// public class Main {
//     public static void main(String args[]) {
//         BT t = new BT();
//         t.root = t.create();
//         t.recoverBST(t.root);
//         t.level(t.root);
//     }
// }

