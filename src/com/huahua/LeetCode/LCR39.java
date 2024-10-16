package src.com.huahua.LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/7/28
 */
public class LCR39 {
    public static void main(String[] args) {
        System.out.println(Solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    static class Solution {
        public static int largestRectangleArea(int[] heights) {
            int n = heights.length;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(right, n);

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < n; ++i) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    right[stack.peek()] = i;
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
            }
            return ans;
        }
    }
}
