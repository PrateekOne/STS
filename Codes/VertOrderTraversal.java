import java.util.*;

class node {
    node left, right;
    int data;

    node(int d) {
        data = d;
        left = right = null;
    }
}

class Qnode {
    node tnode;
    int v;
    int l;

    Qnode(node tnode, int v, int l) {
        this.tnode = tnode;
        this.v = v;
        this.l = l;
    }
}

class VertOrderTraversal {
    node root = null;

    node create(node root, int d) {
        if (root == null) {
            root = new node(d);
        } else if (d <= root.data) {
            root.left = create(root.left, d);
        } else {
            root.right = create(root.right, d);
        }
        return root;
    }

    void vertical(node root, int v, int l) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();
        Queue<Qnode> q = new LinkedList<>();
        q.add(new Qnode(root, 0, 0));

        while (!q.isEmpty()) {
            Qnode curr = q.poll();
            int ver = curr.v;
            int lev = curr.l;

            map.putIfAbsent(ver, new TreeMap<>());
            map.get(ver).putIfAbsent(lev, new ArrayList<>());
            map.get(ver).get(lev).add(curr.tnode.data);

            if (curr.tnode.left != null) {
                q.add(new Qnode(curr.tnode.left, ver - 1, lev + 1));
            }
            if (curr.tnode.right != null) {
                q.add(new Qnode(curr.tnode.right, ver + 1, lev + 1));
            }
        }
    }
}
