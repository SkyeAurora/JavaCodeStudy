package src.com.huahua;

import java.util.Scanner;

/**
 * @description: 大疆笔试 无人机初始左上角，向右走，遇到障碍顺时针 90°
 * 图中 1 - 障碍物  0 - 空地
 * <p>
 * test:
 * 3 3
 * 0 0 0
 * 1 1 0
 * 0 0 0
 * res:
 * 7
 * @author：张佳伟
 * @date: 2024/8/18
 */
public class DJ {
    private static class Solution {

        private int dir = 0, m, n;
        private final int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        /* Write Code Here */
        // 四个方向 右 - 0  下 - 1 左 - 2 上 - 3
        public int numberOfPatrolBlocks(int[][] block) {
            m = block.length;
            n = block[0].length;
            int cnt = 1;
            int step = 0;
            boolean[][] visited = new boolean[m][n];
            visited[0][0] = true;

            int i = 0, j = 0;
            while (true) {
                // 直到走到尽头或障碍物
                while (isNextCanGo(block, i, j)) {
                    step++;
                    i = i + dirs[dir][0];
                    j = j + dirs[dir][1];
                    if (!visited[i][j]) {
                        step = 0;
                        visited[i][j] = true;
                        cnt++;
                    }
                }
                // 顺时针 90 度
                dir = (dir + 1) % 4;
                if (!isNextCanGo(block, i, j) || step >= m * n) {
                    return cnt;
                }
            }
        }

        private boolean isNextCanGo(int[][] block, int i, int j) {
            int ni = i + dirs[dir][0], nj = j + dirs[dir][1];
            return ni >= 0 && ni < m && nj >= 0 && nj < n && block[ni][nj] != 1;
        }
    }

    public static class Main {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int res;

            int block_rows = 0;
            int block_cols = 0;
            block_rows = in.nextInt();
            block_cols = in.nextInt();

            int[][] block = new int[block_rows][block_cols];
            for (int block_i = 0; block_i < block_rows; block_i++) {
                for (int block_j = 0; block_j < block_cols; block_j++) {
                    block[block_i][block_j] = in.nextInt();
                }
            }

            if (in.hasNextLine()) {
                in.nextLine();
            }
            res = new Solution().numberOfPatrolBlocks(block);
            System.out.println(String.valueOf(res));
        }
    }
}
