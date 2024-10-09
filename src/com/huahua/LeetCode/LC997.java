package src.com.huahua.LeetCode;

public class LC997 {
    private static class Solution {
        public int findJudge(int n, int[][] trust) {
            boolean[] flag = new boolean[n + 1];
            flag[0] = true;
            if (n == 1) {
                return 1;
            }
            if (trust.length == 0) {
                return -1;
            }
            int ans = trust[0][1];
            flag[ans] = true;
            for (int[] t : trust) {
                if (t[0] == ans) {
                    return -1;
                }
                if(t[1] == ans){
                    flag[t[1]] = true;
                }
            }
            for (boolean f : flag) {
                if (!f) {
                    return -1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findJudge(4, new int[][]{{1, 3}, {2, 3}}));
    }
}
