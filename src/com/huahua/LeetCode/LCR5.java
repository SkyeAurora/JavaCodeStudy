package src.com.huahua.LeetCode;

public class LCR5 {
    public static void main(String[] args) {
        String[] words = { "aaa", "baz", "foo", "bar", "fxyz", "abcdef" };
        System.out.println(Solution.maxProduct(words));
    }

    class Solution {
        public static int maxProduct(String[] words) {
            int len = words.length;
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    arr[i] |= 1 << (words[i].charAt(j) - 'a');
                }
            }
            // 对于 arr[i]&arr[j]!=0 说明 words[i] 与 words[j] 之间存在相同字符
            int ans = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if ((arr[i] & arr[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
}
