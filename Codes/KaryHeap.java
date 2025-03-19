import java.util.*;
class KaryHeap{
    static int k;
     static ArrayList<Integer> heap=new ArrayList<>();
        static void insert(int d)
        {
            heap.add(d);
            int i=heap.size()-1;
            while(i>0 && heap.get((i-1)/k)<heap.get(i))
            {
                swap((i-1)/k,i);
                i=(i-1)/k;
            }
        }
        static void swap(int pi,int i)
        {
            int temp=heap.get(pi);
            heap.set(pi,heap.get(i));
            heap.set(i,temp);
        }
    public static void main(String agrs[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        k=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            insert(sc.nextInt());
        }
        System.out.print(heap);
    }
}

