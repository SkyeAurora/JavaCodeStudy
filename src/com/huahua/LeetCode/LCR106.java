package src.com.huahua.LeetCode;


/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/18
 */
public class LCR106 {
    /**
     * 染色法 0-未染色 1-红色 2-绿色
     */
    private static class Solution {

        int[] color;
        boolean valid = true;

        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            color = new int[n];

            for (int i = 0; i < n && valid; i++) {
                if (color[i] == 0) {
                    dfs(i, 1, graph);
                }
            }
            return valid;
        }

        private void dfs(int i, int c, int[][] graph) {
            color[i] = c;
            int nextColor = c == 1 ? 2 : 1;
            for (int neighbor : graph[i]) {
                if (color[neighbor] == 0) {
                    dfs(neighbor, nextColor, graph);
                    if (!valid) {
                        return;
                    }
                } else if (color[neighbor] != nextColor) {
                    valid = false;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isBipartite(new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}}));
    }
}
