package src.com.huahua.onLineTest.xiaomi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/19
 */
public class test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // input
        int T = in.nextInt();
        while (T-- > 0) {
            // input
            int n = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }

            System.out.println(canBeSorted(a, b) ? "YES" : "NO");
        }
    }

    private static boolean canBeSorted(int[] a, int[] b) {
        if (isSorted(a) || isSorted(b)) {
            return true;
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1] && b[i] > b[i + 1]) {
                return false;
            }
            if (a[i] < a[i + 1] && b[i] < b[i + 1]) {
                return true;
            }
        }

        Boolean[] canBeAscA = new Boolean[a.length];
        Boolean[] canBeAscB = new Boolean[b.length];

        for (int i = 0; i < a.length; i++) {
            canBeAscA[i] = canSwapToAsc(a, b, i);
            canBeAscB[i] = canSwapToAsc(b, a, i);
        }

        return Arrays.stream(canBeAscA).anyMatch(x -> x) || Arrays.stream(canBeAscB).anyMatch(x -> x);
    }

    private static boolean canSwapToAsc(int[] src, int[] dst, int i) {
        return src[i] <= dst[i];
    }

    private static boolean isSorted(int[] arr) {
        return (isASC(arr) || isDESC(arr));
    }

    private static boolean isDESC(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isASC(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
