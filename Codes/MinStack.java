import java.util.*;
class MinStack{
     Stack<Integer> st=new Stack<>();
     Stack<Integer> mst=new Stack<>();
     void push(int d)
     {
          if(st.isEmpty())
          {
               st.push(d);
               mst.push(d);
          }
          else
          {
               st.push(d);
               if(d<mst.peek())
               {
                    mst.push(d);
               }
          }
     }
     int pop()
     {
      if(st.isEmpty())
      {
           return -1;
      }
      else{
           if(st.peek()==mst.peek())
           {
                mst.pop();
           }
           return st.pop();
      }
     }
     int getMin()
     {
          if(mst.isEmpty())
          {
               return -1;
          }
          return mst.peek();
     }
}
class Main{
     public static void main(String args[])
     {
          Scanner sc=new Scanner(System.in);
          MinStack m=new MinStack();
          int n=sc.nextInt();
          for(int i=0;i<n;i++)
          {
               m.push(sc.nextInt());
          }
          System.out.println(m.pop());
          System.out.println(m.getMin());
     }
}