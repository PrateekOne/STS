import java.util.*;

class Node {
    int data;
    Node left, right;
    Node(int x) { data = x; }
}

class BoundaryTraversal {
    void EN(Node root, List<Integer> al) {
        if (root == null) return;
        if (isLeaf(root)) { al.add(root.data); return; }
        EN(root.left, al);
        EN(root.right, al);
    }

    boolean isLeaf(Node temp) {
        return temp.left == null && temp.right == null;
    }

    void LB(Node root, List<Integer> al) {
        if (root == null) return;
        Node temp = root;
        while (temp != null) {
            if (!isLeaf(temp)) al.add(temp.data);
            temp = (temp.left != null) ? temp.left : temp.right;
        }
    }

    void RB(Node root, List<Integer> al) {
        if (root == null) return;
        List<Integer> temp = new ArrayList<>();
        Node node = root;
        while (node != null) {
            if (!isLeaf(node)) temp.add(node.data);
            node = (node.right != null) ? node.right : node.left;
        }
        Collections.reverse(temp);
        al.addAll(temp);
    }

    List<Integer> boundaryTraversal(Node root) {
        List<Integer> al = new ArrayList<>();
        if (root == null) return al;
        if (!isLeaf(root)) al.add(root.data);
        LB(root.left, al);
        EN(root, al);
        RB(root.right, al);
        return al;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Node> nodes = new HashMap<>();

        // Create nodes
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt(), val = sc.nextInt();
            nodes.put(id, new Node(val));
        }

        // Read edges
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int parent = sc.nextInt(), child = sc.nextInt();
            char dir = sc.next().charAt(0);
            if (nodes.containsKey(parent) && nodes.containsKey(child)) {
                if (dir == 'L') nodes.get(parent).left = nodes.get(child);
                else nodes.get(parent).right = nodes.get(child);
            }
        }

        int rootId = sc.nextInt();
        Node root = nodes.get(rootId);
        System.out.println(new BoundaryTraversal().boundaryTraversal(root));
        sc.close();
    }
}
