package src.com.huahua;

import java.util.Arrays;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/31
 */
public class AlternatePrinting {
    public static int maxProfit(int[] prices, int k) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        k = Math.min(k, (n / 2));

        int[][] buy = new int[n][k + 1];
        int[][] use = new int[n][k + 1];

        buy[0][0] = -prices[0];
        for (int i = 1; i <= k; i++) {
            buy[0][i] = Integer.MIN_VALUE/2;
            use[0][i] = Integer.MIN_VALUE/2;
        }

        for (int i = 1; i < n; i++) {
            buy[i][0] = Math.max(buy[i - 1][0], use[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], use[i - 1][j] - prices[i]);
                use[i][j] = Math.max(use[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(use[n - 1]).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{3, 2, 4, 1, 5}, 3));
    }
}