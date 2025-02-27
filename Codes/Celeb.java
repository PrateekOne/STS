// import java.util.*;
// class Celeb{
//      public static void main(String args[])
//      {
//           Scanner sc=new Scanner(System.in);
//           int n=sc.nextInt();
//           int m[][]=new int[n][n];
//           for(int i=0;i<n;i++)
//           {
//                for(int j=0;j<n;j++)
//                {
//                     m[i][j]=sc.nextInt();
//                }
//           }
//           Stack<Integer> st=new Stack<>();
//           for(int i=0;i<n;i++)
//           {
//                st.push(i);
//           }
//           while(st.size()>1){
//           int x=st.pop();
//           int y=st.pop();
//           if(m[x][y]==1)
//           {
//                st.push(y);
//           }
//           else{
//                st.push(x);
//           }
//      }
//      int c=st.pop();
//      for(int i=0;i<n;i++)
//      {
//           if(i!=c &&(m[c][i]==1 || m[i][c]==0))
//           {
//                System.out.println("No celebrity");
//                return;
//           }
//      }
//      System.out.println(c);
//      }
// }
import java.util.*;
class Celeb{
    static Stack<Integer> st = new Stack<>();
    static void celeb(int n, int a[][]){
        for(int i=0;i<n;i++){
            st.push(i);
        }
        while(st.size() >=2){
        int c = st.pop();
        int d = st.pop();
        
        if(a[c][d] == 1) st.push(d);
        else st.push(c);
        }
        
        int pc =st.pop();
        boolean temp = true;
        for(int i=0;i<n;i++){
            if(i != pc){
            if(a[pc][i] == 1 || a[i][pc] == 0){
                temp = false;
                break;
            }
            }
        }
        if(temp == true) System.out.print("yes");
        else System.out.print("no");
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        celeb(n,a);
    }
}