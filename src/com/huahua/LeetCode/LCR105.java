package src.com.huahua.LeetCode;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/17
 */
public class LCR105 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}}));
    }

    private static class Solution {
        int m, n;
        boolean[][] visited;
        int ans = 0;

        public int maxAreaOfIsland(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            visited = new boolean[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && !visited[i][j]) {
                        ans = Math.max(ans, dfs(grid, i, j));
                    }
                }
            }
            return ans;
        }

        public int dfs(int[][] grid, int i, int j) {
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
                return 0;
            }
            return dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1) + 1;
        }
    }
}
