package src.com.huahua;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/28
 */
public class Youta {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int k = in.nextInt(), n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(maxValue(nums, k));
    }

    public static int maxValue(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE / 2);
        }
        if (nums[0] != -1) {
            dp[0][1] = nums[0];
        }

        for (int i = 1; i < n; i++) {
            if (nums[i] == -1) {
                continue;
            }

            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if (leftChild < n && nums[leftChild] != -1) {
                fillDP(leftChild, k, dp, nums);
            }
            if (rightChild < n && nums[rightChild] != -1) {
                fillDP(rightChild, k, dp, nums);
            }
            for (int j = 0; j <= k; j++) {
                dp[i][j] = Math.max(dp[i][j], j > 0 ? dp[(i - 1) / 2][j - 1] : 0);
            }
            for (int j = 0; j < k; j++) {
                dp[i][j + 1] = Math.max(dp[i][j + 1], dp[(i - 1) / 2][j] + nums[i]);
            }
        }
        int ans = 0;
        for (int j = 0; j <= k; j++) {
            ans = Math.max(ans, dp[0][j]);
        }
        return ans;
    }

    private static void fillDP(int i, int k, int[][] dp, int[] nums) {
        int parent = (i - 1) / 2;
        for (int j = 0; j <= k; j++) {
            dp[i][j] = Math.max(dp[i][j], j > 0 ? dp[parent][j - 1] : 0);
        }
        for (int j = 0; j < k; j++) {
            dp[i][j] = Math.max(dp[i][j + 1], dp[parent][j] + nums[i]);
        }
    }
}
