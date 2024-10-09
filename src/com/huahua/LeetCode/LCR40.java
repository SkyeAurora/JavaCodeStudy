package src.com.huahua.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/28
 */
public class LCR40 {

    public static void main(String[] args) {
        System.out.println(Solution.maximalRectangle(new String[]{"10100", "10111", "11111", "10010"}));
    }

    static class Solution {
        public static int maximalRectangle(String[] matrix) {
            int m = matrix.length, n = matrix[0].length();
            int[][] nums = new int[m][n];
            for (int j = 0; j < n; j++) {
                int p = 0;
                for (int i = 0; i < m; i++) {
                    if (matrix[i].charAt(j) == '1') {
                        nums[i][j] = ++p;
                    } else {
                        p = 0;
                        nums[i][j] = 0;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                ans = Math.max(ans,largestRectangleArea(nums[i]));
            }
            return ans;
        }

        private static int largestRectangleArea(int[] heights) {
            int len = heights.length;
            int[] left = new int[len];
            int[] right = new int[len];
            Arrays.fill(right, len);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    right[stack.peek()] = i;
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            int ans = 0;
            for (int i = 0; i < len; i++) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }
    }
}
