import java.util.*;
class node{
     int data;
     node next,prev;
     node(int d)
     {
          data=d;
          next=prev=null;
     }
}
class DLL{
     node head=null;
     void insert(int d)
     {
          node newn=new node(d);
          if(head==null)
          {
               head=newn;
          }
          else{
               node temp=head;
               while(temp.next!=null)
               {
                    temp=temp.next;
               }
               temp.next=newn;
               newn.prev=temp;
          }
     }
     void sort()
     {
          node first=head;
          node last=head;
          while(last.next!=null){ last=last.next;}
          node s=null;
          node e=null;
          while(first!=last)
          {
               if(first.data<=last.data)
               {
                    if(s==null)
                    {
                         s=e=first;
                         first=first.next;
                    }
                    else{
                         e.next=first;
                         first.prev=e;
                         e=e.next;
                         first=first.next;
                    }
               }
               else{
                    if(s==null)
                    {
                         s=e=last;
                         last=last.prev;
                    }
                    else{
                         e.next=last;
                         node curr=last.prev;
                         last.prev=e;
                         e=e.next;
                         last=curr;
                    }
               }
          }
          e.next=first;
          first.prev=e;
          e.next=null;
          head=s;
     }
     void print(){
          node temp=head;
          while(temp!=null)
          {
               System.out.print(temp.data+" ");
               temp=temp.next;
          }
     }
}
class BiTonic{
     
     static public void main(String args[])
     {
          Scanner sc=new Scanner(System.in);
          DLL l=new DLL();
          int n=sc.nextInt();
          for(int i=0;i<n;i++)
          {
              l.insert(sc.nextInt());
          }
          l.sort();
          l.print();
     }
}
















