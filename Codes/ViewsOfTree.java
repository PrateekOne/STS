import java.util.*;
class node{
    int data;
    node left,right;
    node(int s)
    {
        data=s;
        left=right=null;
    }
}
class BT{
    node root=null;
    node create()
    {
        Scanner sc=new Scanner(System.in);
        int rd=sc.nextInt();
        if(rd==-1)
        {
            return null;
        }
        node newn=new node(rd);
        root=newn;
        Queue<node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            node curr=q.poll();
            int ld=sc.nextInt();
            if(ld!=-1)
            {
                node lnode=new node(ld);
                curr.left=lnode;
                q.add(lnode);
            }
            int rnd=sc.nextInt();
            if(rnd!=-1)
            {
                node rnode=new node(rnd);
                curr.right=rnode;
                q.add(rnode);
            }
        }
        return root;
    }
    void RV(node root,int l,ArrayList<Integer> al)
    {
        if(root==null)
        {
            return;
        }
        if(l==al.size())
        {
            al.add(root.data);
        }
        if(root.left!=null)
        {
            RV(root.left,l+1,al);
        }
        if(root.right!=null)
        {
            RV(root.right,l+1,al);
        }
    }
}
public class ViewsOfTree{
    public static void main(String ar[])
    {
        BT t=new BT();
        t.root=t.create();
        ArrayList<Integer> al=new ArrayList<>();
        t.RV(t.root,0,al);
        System.out.println(al);
    }
}

// Input : 1 3 2 5 6 4 -1 -1 -1 7 -1 -1 -1 -1 -1