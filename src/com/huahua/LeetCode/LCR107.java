package src.com.huahua.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/18
 */
public class LCR107 {
    private static class Solution {
        int[][] ans;
        boolean[][] visited;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length;
            visited = new boolean[m][n];
            ans = new int[m][n];

            Queue<int[]> queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) {
                        queue.add(new int[]{i, j});
                        visited[i][j] = true;
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] q = queue.poll();
                int i = q[0], j = q[1];
                for (int[] dir : dirs) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                        ans[ni][nj] = ans[i][j] + 1;
                        queue.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}})));
    }
}
