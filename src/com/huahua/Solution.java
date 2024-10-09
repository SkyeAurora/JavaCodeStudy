package src.com.huahua;

import java.util.Scanner;

public class Solution {
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        String s = in.nextLine();

        long[][] dp = new long[n + 1][3];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '?') {
                for (int d = 0; d <= 9; d++) {
                    for (int j = 0; j < 3; j++) {
                        dp[i + 1][(j + d) % 3] = (dp[i + 1][(j + d) % 3] + dp[i][j]);
                    }
                }
            } else {
                int d = c - '0';
                for (int j = 0; j < 3; j++) {
                    dp[i + 1][(j + d) % 3] = (dp[i + 1][(j + d) % 3] + dp[i][j]);
                }
            }
        }

        System.out.println(dp[n][0]);
    }
}
