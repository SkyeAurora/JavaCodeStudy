package src.com.huahua.onLineTest.xiaomi;

import java.util.Scanner;

/**
 * @description: 小米1
 * @author：张佳伟
 * @date: 2024/9/19
 */
public class test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // input
        int T = in.nextInt();
        while (T-- > 0) {
            // input
            int N = in.nextInt(), n = in.nextInt(), c = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            System.out.println(canFillBox(N, a, c) ? "YES" : "NO");
        }
    }

    public static boolean canFillBox(int N, int[] toys, int c) {
        // dp[i] 表示容量为i的箱子可以被装满
        boolean[] dp = new boolean[N + 1];
        dp[0] = true;

        for (int toy : toys) {
            for (int j = N; j >= toy; j--) {
                dp[j] = dp[j] || dp[j - toy];
            }
        }
        for (int i = 0; i <= c; i++) {
            if (dp[N - i]) {
                return true;
            }
        }
        return false;
    }
}
