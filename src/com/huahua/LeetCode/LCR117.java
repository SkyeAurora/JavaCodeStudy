package src.com.huahua.LeetCode;

public class LCR117 {
    private static class Solution {
        int[] f;

        public int find(int p) {
            return f[p];
        }

        public void union(int p, int q) {
            int pId = find(p);
            int qId = find(q);

            if (pId == qId) {
                return;
            }

            for (int i = 0; i < f.length; i++) {
                if (f[i] == pId) {
                    f[i] = qId;
                }
            }
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            f = new int[n];
            for (int i = 0; i < n; i++) {
                f[i] = i;
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (find(i) == find(j)) {
                        continue;
                    }
                    if (isSimilarStr(strs[i], strs[j])) {
                        union(i, j);
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (f[i] == i) {
                    cnt++;
                }
            }
            return cnt;
        }

        public boolean isSimilarStr(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            if (s1.equals(s2)) {
                return true;
            }
            int cnt = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (cnt++ > 2) {
                        return false;
                    }
                }
            }
            return cnt == 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSimilarGroups(new String[]{"tars", "rats", "arts", "star"}));
    }
}
