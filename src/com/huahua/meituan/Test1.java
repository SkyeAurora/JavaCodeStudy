package src.com.huahua.meituan;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/9
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), k = in.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        long[] p1 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            p1[i] = p1[i - 1] + nums[i - 1];
        }

        if (k > 0) {
            // 小美的最佳策略
            int l = -1, r = -1;
            long cur = -1;
            for (int i = 0; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (cur < p1[j] - p1[i]) {
                        cur = p1[j] - p1[i];
                        l = i;
                        r = j;
                    }
                }
            }
            for (int i = l; i < r; i++) {
                nums[i] = nums[i] * k;
            }

            for (int i = 1; i <= n; i++) {
                p1[i] = p1[i - 1] + nums[i - 1];
            }

            // 小团的最佳策略
            l = -1;
            r = -1;
            cur = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (cur > p1[j] - p1[i]) {
                        cur = p1[j] - p1[i];
                        l = i;
                        r = j;
                    }
                }
            }
            for (int i = l; i < r; i++) {
                nums[i] = nums[i] * k;
            }
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            System.out.println(sum);
        } else {
            int l = -1, r = -1;
            long cur = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (cur > p1[j] - p1[i]) {
                        cur = p1[j] - p1[i];
                        l = i;
                        r = j;
                    }
                }
            }
            for (int i = l; i < r; i++) {
                nums[i] = nums[i] * k;
            }

            // 小美的最佳策略
            l = -1;
            r = -1;
            cur = -1;
            for (int i = 0; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (cur < p1[j] - p1[i]) {
                        cur = p1[j] - p1[i];
                        l = i;
                        r = j;
                    }
                }
            }
            for (int i = l; i < r; i++) {
                nums[i] = nums[i] * k;
            }
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            System.out.println(sum);
        }


    }
}
