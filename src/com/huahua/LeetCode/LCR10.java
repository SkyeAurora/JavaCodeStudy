package src.com.huahua.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LCR10 {
    public static void main(String[] args) {
        System.out.println(Solution.subarraySum(new int[] { -1, -1, 1 }, 0));
    }

    class Solution {
        public static int subarraySum(int[] nums, int k) {
            int len = nums.length;
            int[] sumArr = new int[len + 1];
            sumArr[1] = nums[0];
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, 0);
            for (int i = 1; i <= len; i++) {
                sumArr[i] = sumArr[i - 1] + nums[i - 1];
                map.put(sumArr[i], i);
            }

            int ans = 0;
            for (int i = 1; i <= len; i++) {
                if (map.containsKey(sumArr[i] - k) && map.get(sumArr[i] - k) < i) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
