package src.com.huahua.LeetCode;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/5
 */
public class LCR116 {
    private static class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(isConnected, i, visited);
                    ans++;
                }
            }
            return ans;
        }

        private void dfs(int[][] isConnected, int start, boolean[] visited) {
            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[start][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    dfs(isConnected, i, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
