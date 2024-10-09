package src.com.huahua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/5
 */
public class LCR86 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new LCR86().partition("google")));
    }

    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[][] dp;
    int len;

    public String[][] partition(String s) {
        // 动规预处理
        len = s.length();
        dp = new boolean[len][len];
        // dp初始化
        dp[0][0] = true;
        for (int i = 1; i < len; i++) {
            dp[i][i] = true;
            dp[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        for (int j = 2; j < len; j++) {
            for (int i = 0; i < j - 1; i++) {
                dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
            }
        }

        // 回溯
        backTracking(s, 0);
        int m = ans.size();
        String[][] ret = new String[m][];
        for (int i = 0; i < m; i++) {
            int n = ans.get(i).size();
            ret[i] = new String[n];
            for (int j = 0; j < n; j++) {
                ret[i][j] = ans.get(i).get(j);
            }
        }
        return ret;
    }

    private void backTracking(String s, int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        List<String> list = new ArrayList<>();
        for (int j = i; j < len; j++) {
            if (dp[i][j]) {
                list.add(s.substring(i, j + 1));
            }
        }
        for (String str : list) {
            path.add(str);
            backTracking(s, i + str.length());
            path.remove(path.size() - 1);
        }
    }
}
