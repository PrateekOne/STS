import java.util.*;
class node{
     int data;
     node next;
     node(int d)
     {
          data=d;
          next=null;
     }
}
class StackLL{
     node top=null;
     void push(int d)
     {
          node newn=new node(d);
          if(top==null)
          {
               top=newn;
          }
          else{
               newn.next=top;
               top=newn;
          }
     }
     int pop()
     {
          if(top==null)
          {
               return -1;
          }
          else{
               int temp=top.data;
               top=top.next;
               return temp;
          }
     }
     int peek()
     {
          if(top==null)
          {
               return -1;
          }
          return top.data;
     }
     void display()
     {
          node temp=top;
          while(temp!=null)
          {
               System.out.print(temp.data+" ");
               temp=temp.next;
          }
     }
}
class Main{
     public static void main(String args[])
     {
          Scanner sc=new Scanner(System.in);
          StackLL l=new StackLL();
          int n=sc.nextInt();
          for(int i=0;i<n;i++)
          {
               l.push(sc.nextInt());
          }
          System.out.println(l.pop());
          System.out.println(l.peek());
          l.display();
     }
}













