// Sort the queue without using the extra space (Code given by ma'am)
// Date : {23-01-2025}
import java.util.*;
class SortQ{
    static void SortQueue(Queue<Integer> q)
    {
        int size=q.size();
        for(int i=1;i<=size;i++)
        {
            int I=FindMin(q,size-i);
            AddMin(q,I);
        }
    }
    static void AddMin(Queue<Integer> q,int I)
    {
        int temp=0;
        int size=q.size();
        for(int i=0;i<size;i++)
        {
            int c=q.poll();
            if(i==I)
            {
                temp=c;
            }
            else{
                q.add(c);
            }
        }
        q.add(temp);
    }
    static int FindMin(Queue<Integer> q,int ms)
    {
        int Minval=Integer.MAX_VALUE;
        int Minind=-1;
        int size=q.size();
        for(int i=0;i<size;i++)
        {
            int temp=q.poll();
            if(temp<Minval && i<=ms)
            {
                Minval=temp;
                Minind=i;
            }
            q.add(temp);
        }
        return Minind;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            q.add(sc.nextInt());
        }
        SortQueue(q);
        System.out.println(q);
    }
}