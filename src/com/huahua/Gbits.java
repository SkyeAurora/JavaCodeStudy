package src.com.huahua;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/28
 */
public class Gbits {
    private static final double PI = Math.PI;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), l = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
    }

    private double calN(int a, int N) {
        if (N == -1) {
            return a * a / (4 * PI);
        }
        return (a * a) / (4 * N * Math.tan(PI / N));
    }
}
