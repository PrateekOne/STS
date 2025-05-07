import java.util.*;

public class LIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], dp = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (a[i] > a[j]) dp[i] = Math.max(dp[i], dp[j]+1);
        int res = 0;
        for (int x : dp) res = Math.max(res, x);
        System.out.println(res);
    }
}
