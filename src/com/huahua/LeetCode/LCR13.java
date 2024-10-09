package src.com.huahua.LeetCode;

public class LCR13 {

    public static void main(String[] args) {
        NumMatrix numMatrix = new NumMatrix(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });

        
    }

    static class NumMatrix {
        int m;
        int n;
        int[][] sumArr;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            this.sumArr = new int[m + 1][n + 1];
            this.m = m + 1;
            this.n = n + 1;
            for (int i = 1; i <= m; i++) {
                int pre = 0;
                for (int j = 1; j <= n; j++) {
                    pre += matrix[i - 1][j - 1];
                    sumArr[i][j] = sumArr[i - 1][j] + pre;
                }
            }
            System.out.println(" ");
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            // TODO
            return 0;
        }
    }
}
