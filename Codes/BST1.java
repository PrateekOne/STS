import java.util.*;
class node{
    int data;
    node left,right;
    node(int d)
    {
        left=right=null;
        data=d;
    }
}
class BT{
    node root=null;
    node prev=null;
    node f=null;
    node m=null;
    node l=null;
    node create()
    {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        if(r==-1)
        {
            return null;
        }
        node newn=new node(r);
        root=newn;
        Queue<node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            node curr=q.poll();
            int l=sc.nextInt();
            if(l!=-1)
            {
                node lnode=new node(l);
                q.add(lnode);
                curr.left=lnode;
            }
            int rn=sc.nextInt();
            if(rn!=-1)
            {
                node rnode=new node(rn);
                q.add(rnode);
                curr.right=rnode;
            }
        }
        return root;
    }
    void recoverBST(node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root);
        if(f!=null && l!=null)
        {
            int temp=f.data;
            f.data=l.data;
            l.data=temp;
        }
        else if(f!=null && m!=null)
        {
            int temp=f.data;
            f.data=m.data;
            m.data=temp;
        }
    }
    void inorder(node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.data>root.data)
        {
            if(f==null)
            {
                f=prev;
                m=root;
            }
            else{
                l=root;
                }
        }
        prev=root;
        inorder(root.right);
    }
    void level(node root)
    {
        Queue<node> q=new LinkedList<>();
        if(root==null)
        {
            return;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            node curr=q.poll();
            System.out.print(curr.data+" ");
            if(curr.left!=null)
            {
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                q.add(curr.right);
            }
        }
        
    }
}
class Main{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        BT t=new BT();
        t.root=t.create();
        t.recoverBST(t.root);
        t.level(t.root);
    }
}