import java.util.*;
class TopoSort{
    static void dfs(LinkedList<LinkedList<Integer>> l,int v)
    {
        boolean vis[]=new boolean[v];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<v;i++)
        {
            if(vis[i]==false)
            {
                helper(l,i,vis,st);
            }
        }
        while(!st.isEmpty())
        {
            System.out.print(st.pop()+" ");
        }
    }
    static void helper(LinkedList<LinkedList<Integer>> l,int s,boolean vis[],Stack<Integer> st)
{
    vis[s]=true;
    for(int adj: l.get(s))
    {
        if(!vis[adj])
        {
            helper(l,adj,vis,st);
        }
    }
    st.push(s);
}
    public static void main(String ars[])
    {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        LinkedList<LinkedList<Integer>> l=new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            l.add(new LinkedList<>());
        }
        for(int i=0;i<e;i++)
        {
            int s=sc.nextInt();
            int d=sc.nextInt();
            l.get(s).add(d);
        }
        dfs(l,v);
    }
}
