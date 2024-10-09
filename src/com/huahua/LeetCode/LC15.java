package src.com.huahua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 三数之和
 * @author：张佳伟
 * @date: 2024/8/22
 */
public class LC15 {
    private static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            for (int left = 0; left < len; left++) {
                // 保证 first 不重复枚举
                if (left > 0 && nums[left] == nums[left - 1]) {
                    continue;
                }
                int right = len - 1;
                for (int mid = left + 1; mid < len - 1; mid++) {
                    if (mid > left + 1 && nums[mid] == nums[mid - 1]) {
                        continue;
                    }
                    while (mid < right && nums[left] + nums[mid] + nums[right] > 0) {
                        right--;
                    }
                    if (mid == right) {
                        break;
                    }
                    if (nums[left] + nums[mid] + nums[right] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[left]);
                        list.add((nums[mid]));
                        list.add(nums[right]);
                        ans.add(list);
                    }
                }
            }
            return ans;
        }
    }
}
