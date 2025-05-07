import java.util.*;

class SubsetProbRec {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ter = 6;
        boolean result = f(n - 1, ter, arr);
        System.out.println(result);
        sc.close();
    }

    public static boolean f(int ind, int tar, int[] a) {
        if (tar == 0) {
            return true;
        }
        if (ind < 0) {
            return false;
        }
        boolean exclude = f(ind - 1, tar, a);
        boolean include = false;
        if (a[ind] <= tar) {
            include = f(ind - 1, tar - a[ind], a);
        }
        return include || exclude;
    }
}