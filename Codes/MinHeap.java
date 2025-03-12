import java.util.*;
class MinHeap{
    static ArrayList<Integer> heap=new ArrayList<>();
    static int parent(int i)
    {
        return (i-1)/2;
    }
    static void insert(int d)
    {
        heap.add(d);
        int i=heap.size()-1;
        while(i>0 && heap.get(parent(i))>heap.get(i))
        {
            swap(heap,parent(i),i);
            i=parent(i);
        }
    }
    static void swap(ArrayList<Integer> heap,int pi,int i)
    {
        int temp=heap.get(pi);
        heap.set(pi,heap.get(i));
        heap.set(i,temp);
    }
    public static void main(String ars[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            insert(sc.nextInt());
        }
        System.out.print(heap);
    }
}