import java.util.*;
class node{
    int data;
    node left,right;
    node(int d)
    {
        data=d;
        left=right=null;
    }
}
class BST{
    node root=null;
    node create(node root,int s)
    {
        if(root==null)
        {
            root=new node(s);
            return root;
        }
        else if(s<=root.data)
        {
            root.left=create(root.left,s);
        }
        else if(s>root.data)
        {
            root.right=create(root.right,s);
        }
        return root;
    }
    void inorder(node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
}
class Main{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BST t=new BST();
        for(int i=0;i<n;i++)
        {
            int data=sc.nextInt();
            t.root=t.create(t.root,data);
        }
        t.inorder(t.root);
    }
}