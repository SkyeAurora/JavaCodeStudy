package src.com.huahua.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/9
 */
public class Test2 {
    public static void main(String[] args) {
        final long MOD = (long) (1e9 + 7);

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        Arrays.sort(nums);
        long res = 0;

        // 整除的情况
        if (sum % n == 0) {
            //众数等于平均数
            long mode = sum / n;
            res = calculateOperation(0, n, mode, nums);
        } else {
            // 舍弃最小值
            long curSum = sum - nums[0];
            long mode = curSum / (n - 1);
            // 如果不能整除 那么 mode + 1 作为众数也是有可能的
            long res1 = Math.min(calculateOperation(1, n, mode, nums), calculateOperation(1, n, mode + 1, nums));
            // 舍弃最大值
            curSum = sum - nums[n - 1];
            mode = curSum / (n - 1);
            long res2 = Math.min(calculateOperation(0, n - 1, mode, nums), calculateOperation(0, n - 1, mode + 1, nums));
            res = Math.min(res1, res2);
        }
        System.out.println(res);
    }

    // 计算操作次数
    private static long calculateOperation(int start, int end, long mode, int[] nums) {
        long left = 0, right = 0;
        for (int i = start; i < end; i++) {
            if (nums[i] < mode) {
                left += Math.abs(nums[i] - mode);
            } else {
                right += Math.abs(nums[i] - mode);
            }
        }
        // 相等也就说明能整除 左边的数 + 1 和 右边的数 - 1 刚好能让所有成为众数
        if (left == right)
            return left;
        else // 不能整除 abs(left - right) 多出来的数需要和舍弃的数操作
            return Math.max(left, right);
    }
}
