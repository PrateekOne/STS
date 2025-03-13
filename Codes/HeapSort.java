import java.util.*;
class HeapSort{
    static ArrayList<Integer> heap=new ArrayList<>();
    static int parent(int i)
    {
        return (i-1)/2;
    }
    static void swap(int pi,int i)
    {
        int temp=heap.get(pi);
        heap.set(pi,heap.get(i));
        heap.set(i,temp);
    }
    static void maxheap(int d)
    {
        heap.add(d);
        int i=heap.size()-1;
        while(i>0 && heap.get(parent(i))<heap.get(i))
        {
            swap(parent(i),i);
            i=parent(i);
        }
    }
    static int Extractmax(ArrayList<Integer> heap)
    {
        int max=heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapify(0);
        return max;
    }
    static void heapify(int i)
    {
        int large=i;
        int left=(2*i)+1;
        int right=(2*i)+2;
        if(left<heap.size() && heap.get(large)<heap.get(left))
        {
            large=left;
        }
        if(right<heap.size() && heap.get(large)<heap.get(right))
        {
            large=right;
        }
        if(large!=i)
        {
            swap(large,i);
            heapify(large);
        }
    }
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            maxheap(sc.nextInt());
        }
        System.out.println(heap);
        int s[]=new int[n];
        for(int i=n-1;i>=0;i--)
        {
            s[i]=Extractmax(heap);
        }
        System.out.println(Arrays.toString(s));
    }
}

// 6
// 26 12 34 5 10 16







