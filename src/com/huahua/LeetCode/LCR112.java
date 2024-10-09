package src.com.huahua.LeetCode;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/30
 */
public class LCR112 {
    private class Solution {
        private static final int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] dp;

        public int longestIncreasingPath(int[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
            }
            int m = matrix.length, n = matrix[0].length;
            dp = new int[m][n];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, dfs(i, j, matrix));
                }
            }
            return ans;
        }

        private int dfs(int i, int j, int[][] matrix) {
            if (dp[i][j] != 0) {
                return dp[i][j];
            }
            int cnt = 0;
            for (int[] direction : directions) {
                int ni = i + direction[0], nj = j + direction[1];
                if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && matrix[ni][nj] > matrix[i][j]) {
                    cnt = Math.max(cnt, dfs(ni, nj, matrix));
                }
            }
            dp[i][j] = cnt + 1;
            return dp[i][j];
        }
    }

    public static void main(String[] args) {
        System.out.println(new LCR112().new Solution().longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}));
    }
}
