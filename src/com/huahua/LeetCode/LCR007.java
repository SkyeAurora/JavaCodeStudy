package src.com.huahua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/25
 */
public class LCR007 {
    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            for (int left = 0; left < len; left++) {
                if (left > 0 && nums[left] == nums[left - 1]) {
                    continue;
                }
                int right = len - 1;
                for (int mid = left + 1; mid < len; mid++) {
                    if (mid > left + 1 && nums[mid] == nums[mid - 1]) {
                        continue;
                    }
                    while (mid < right && nums[left] + nums[right] + nums[mid] > 0) {
                        right--;
                    }
                    if (mid == right) {
                        break;
                    }
                    if (nums[left] + nums[right] + nums[mid] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add(nums[mid]);
                        list.add(nums[right]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
