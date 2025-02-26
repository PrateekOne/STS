import java.util.*;

class GraphDFS {
    static void dfs(ArrayList<ArrayList<Integer>> al, int sr, int v) {
        boolean vis[] = new boolean[v]; // Visited array should be initialized once
        helper(al, sr, vis);
    }

    static void helper(ArrayList<ArrayList<Integer>> al, int s, boolean vis[]) {
        vis[s] = true;
        System.out.print(s + " ");
        for (int adj : al.get(s)) {
            if (!vis[adj]) {
                helper(al, adj, vis);
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            al.get(s).add(d);
            al.get(d).add(s);
        }
        int sr = sc.nextInt();
        dfs(al, sr, v);
        sc.close();
    }
}
