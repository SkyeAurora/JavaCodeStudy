package src.com.huahua.LeetCode;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/13
 */
class Solution {
    int[] nums;
    int n, target, sum = 0;
    boolean flag;
    boolean[] isBadSum;

    public boolean canPartition(int[] nums) {
        int total = 0, max = 0;
        for (int num : nums) {
            total += num;
            max = Math.max(max, num);
        }
        if ((total & 1) == 1 || max > total / 2) {
            return false;
        }
        this.nums = nums;
        this.n = nums.length;
        this.target = total / 2;
        this.isBadSum = new boolean[target + 1];
        this.flag = false;
        backTrack(0);
        return flag;
    }

    private void backTrack(int i) {
        if (flag || sum > target || isBadSum[sum]) {
            return;
        }
        if (sum == target) {
            flag = true;
            return;
        }
        for (; i < n - 1; i++) {
            sum += nums[i];
            backTrack(i + 1);
            sum -= nums[i];
            isBadSum[sum] = true;
        }
    }
}

public class LCR101 {
    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
    }
}
