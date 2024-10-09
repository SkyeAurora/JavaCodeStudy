package src.com.huahua.TecentMusic;

import java.util.Scanner;

public class Solution {
    private static final int MOD = 1000000007;
    private static long ans = 0;
    private static long sum = 0;
    private static int count = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();

        String s = in.nextLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '?') {
                count++;
            } else {
                sum += c - '0';
            }
        }
        if (s.charAt(0) == '?') {
            for (int i = 1; i <= 9; i++) {
                sum += i;
                dfs(1);
                sum -= i;
            }
        } else {
            dfs(0);
        }
        System.out.println(ans % MOD);
    }

    private static void dfs(int index) {
        if (index == count) {
            if (sum % 3 == 0) {
                ans++;
            }
            return;
        }
        for (int i = 0; i <= 9; i++) {
            sum += i;
            dfs(index + 1);
            sum -= i;
        }
    }
}