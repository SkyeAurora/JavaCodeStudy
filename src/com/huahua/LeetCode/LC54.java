package src.com.huahua.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/22
 */
public class LC54 {
    private static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> ans = new ArrayList<>();
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return ans;
            }
            int m = matrix.length, n = matrix[0].length;
            int left = 0, right = n - 1, top = 0, down = m - 1;
            while (left <= right && top <= down) {
                for (int j = left; j <= right; j++) {
                    ans.add(matrix[top][j]);
                }
                for (int i = top + 1; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                if (left < right && top < down) {
                    for (int j = right - 1; j > left; j--) {
                        ans.add(matrix[down][j]);
                    }
                    for (int i = down; i > top; i--) {
                        ans.add(matrix[i][left]);
                    }
                }
                left++;
                right--;
                top++;
                down--;
            }
            return ans;
        }
    }
}
