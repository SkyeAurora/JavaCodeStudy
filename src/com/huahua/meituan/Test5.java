package src.com.huahua.meituan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/9
 */
public class Test5 {

    public static int getFactor(int x, int factor) {
        int count = 0;
        while (x % factor == 0) {
            x /= factor;
            count++;
        }
        return count;
    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = ((r - l) >> 1) + l;
            if (target >= arr[mid]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        Scanner in = new Scanner((System.in));

        int n = in.nextInt(), k = in.nextInt();
        int[] p2 = new int[n + 1], p5 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            p2[i + 1] = getFactor(a, 2) + p2[i];
            p5[i + 1] = getFactor(a, 5) + p5[i];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int f2 = binarySearch(p2, p2[i] + p2[n] - k);
            int f5 = binarySearch(p5, p5[i] + p5[n] - k);
            ans += Math.min(f2, f5) > i + 1 ? Math.min(f2, f5) - i - 1 : 0;
        }
        System.out.println(ans);
    }
}
