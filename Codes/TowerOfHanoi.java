import java.util.*;
class TowerOfHanoi{
    static Stack<Integer> sr=new Stack<>();
    static Stack<Integer> ax=new Stack<>();
    static Stack<Integer> ds=new Stack<>();
   static void move(Stack<Integer> s1,Stack<Integer> s2,char a ,char b)
    {
        int v1,v2;
        if(s1.isEmpty())
        {
            v1=0;
        }
        else{
            v1=s1.pop();
        }
         if(s2.isEmpty())
        {
            v2=0;
        }
        else{
            v2=s2.pop();
        }
        if(v2==0)
        {
            s2.push(v1);
            System.out.println(v1 +" moves from " + a+ " to "+ b);
            
        }
        else if(v1==0)
        {
            s1.push(v2);
            System.out.println(v2 +" moves from " + b+ " to "+ a);
        }
        else if(v1>v2)
        {
            s1.push(v1);
            s1.push(v2);
            System.out.println(v2 +" moves from " + b+ " to "+ a);
        }
        else{
            s2.push(v2);
            s2.push(v1);
            System.out.println(v1 +" moves from " + a+ " to "+ b);
        }
    }
    public static void main(String arfs[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=n;i>0;i--)
        {
            sr.push(i);
        }
        int m=(int)Math.pow(2,n)-1;
        char s='S',a='A',d='D';
        if(n%2==0)
        {
            char temp=a;
            a=d;
            d=temp;
        }
        for(int i=1;i<=m;i++)
        {
            if(i%3==1) { move(sr,ds,s,d);}
            if(i%3==2) { move(sr,ax,s,a);}
            if(i%3==0) {
              move(ds,ax,d,a);
            }
        }
        
        
    }
}