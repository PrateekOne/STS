    import java.util.Scanner;

    class SubsetProbTab {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int ter = 6;
            boolean result = subsetSum(n, ter, arr);
            System.out.println(result);
            sc.close();
        }

        public static boolean subsetSum(int n, int tar, int[] a) {
            boolean[][] dp = new boolean[n + 1][tar + 1];

            for (int i = 0; i <= n; i++) {
                dp[i][0] = true;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= tar; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (a[i - 1] <= j) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - a[i - 1]];
                    }
                }
            }

            return dp[n][tar];
        }
    }