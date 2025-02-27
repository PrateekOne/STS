    import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class Qnode {
    Node node;
    int v, l;

    Qnode(Node node, int v, int l) {
        this.node = node;
        this.v = v;
        this.l = l;
    }
}

class VerticalTrav {
    Node root = null;

    Node create(Node root, int d) {
        if (root == null) {
            return new Node(d);
        } else if (d <= root.data) {
            root.left = create(root.left, d);
        } else {
            root.right = create(root.right, d);
        }
        return root;
    }

    public void verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, LinkedList<Integer>>> map = new TreeMap<>();
        Queue<Qnode> qdata = new LinkedList<>();
        qdata.offer(new Qnode(root, 0, 0));
        while (!qdata.isEmpty()) {
            Qnode curr = qdata.poll();
            int ver = curr.v;
            int level = curr.l;

            map.putIfAbsent(ver, new TreeMap<>());
            map.get(ver).putIfAbsent(level, new LinkedList<>());
            map.get(ver).get(level).add(curr.node.data);

            if (curr.node.left != null) {
                qdata.offer(new Qnode(curr.node.left, ver - 1, level + 1));
            }
            if (curr.node.right != null) {
                qdata.offer(new Qnode(curr.node.right, ver + 1, level + 1));
            }
        }
        for(TreeMap<Integer,LinkedList<Integer>> level:map.values())
        {
            for(LinkedList<Integer> al:level.values())
            {
                for(int n:al)
                {
                    System.out.print(n+" ");
                }
            }
        }
    
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VerticalTrav tree = new VerticalTrav();
        System.out.println("Enter number of nodes:");
        int n = scanner.nextInt();
        System.out.println("Enter node values:");
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            tree.root = tree.create(tree.root, value);
        }
        System.out.println("Vertical Order Traversal:");
        tree.verticalTraversal(tree.root);
    }
}
