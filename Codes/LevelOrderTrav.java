import java.util.*;

class node {
    int data;
    node left, right;

    node(int d) {
        data = d;
        left = right = null;
    }
}

class BT {
    node root = null;

    node create() {
        Scanner sc = new Scanner(System.in);
        int rd = sc.nextInt();
        if (rd == -1) {
            return null;
        }
        node newn = new node(rd);
        root = newn;
        Queue<node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            node curr = q.poll();
            int ld = sc.nextInt();
            if (ld != -1) {
                node lnode = new node(ld);
                curr.left = lnode;
                q.add(lnode);
            }
            int rnd = sc.nextInt();
            if (rnd != -1) {
                node rnode = new node(rnd);
                curr.right = rnode;
                q.add(rnode);
            }
        }
        return root;
    }

    void levelorder(node root) {
        Queue<node> q = new LinkedList<>();
        if (root == null) {
            return;
        }
        q.add(root);
        while (!q.isEmpty()) {
            node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }
}

public class LevelOrderTrav {
    public static void main(String a[]) {
        BT t = new BT();
        t.root = t.create();
        t.levelorder(t.root);
    }
}
