package src.com.huahua.LeetCode;

import java.util.*;

/**
 * @description: 拓朴排序
 * @author：张佳伟
 * @date: 2024/9/3
 */
public class LCR114 {
    private static class Solution {
        Map<Character, List<Character>> edges = new HashMap<>();
        int[] indegrees = new int[26];

        {
            Arrays.fill(indegrees, -1);
        }

        public String alienOrder(String[] words) {
            int cnt = 0;
            for (String word : words) {
                for (int j = 0; j < word.length(); j++) {
                    if (indegrees[word.charAt(j) - 'a'] == -1) {
                        indegrees[word.charAt(j) - 'a'] = 0;
                        cnt++;
                    }
                }
            }
            for (int i = 1; i < words.length; i++) {
                if (addEdges(words[i - 1], words[i]) < 0) {
                    return "";
                }
            }

//            for (Map.Entry<Character, List<Character>> entry : edges.entrySet()) {
//                char key = entry.getKey();
//                List<Character> list = entry.getValue();
//                System.out.println(key + ":" + list);
//            }
//            System.out.println(Arrays.toString(indegrees));

            Queue<Character> queue = new LinkedList<>();
            for (int i = 0; i < 26; i++) {
                if (indegrees[i] == 0) {
                    queue.offer((char) (i + 'a'));
                }
            }
            StringBuilder ans = new StringBuilder();
            while (!queue.isEmpty()) {
                char p = queue.poll();
                ans.append(p);
                List<Character> list = edges.get(p);
                if (list == null) {
                    continue;
                }
                for (char c : list) {
                    indegrees[c - 'a']--;
                    if (indegrees[c - 'a'] == 0) {
                        queue.offer(c);
                    }
                }
            }
            return ans.length() != cnt ? "" : ans.toString();
        }

        private int addEdges(String before, String after) {
            int len1 = before.length(), len2 = after.length();
            int minLen = Math.min(len1, len2);
            for (int i = 0; i < minLen; i++) {
                if (before.charAt(i) != after.charAt(i)) {
                    List<Character> edge = edges.getOrDefault(before.charAt(i), new ArrayList<>());
                    edge.add(after.charAt(i));
                    edges.put(before.charAt(i), edge);
                    indegrees[after.charAt(i) - 'a']++;
                    return 0;
                }
            }
            return len2 - len1;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().alienOrder(new String[]{"z", "x", "a", "zb", "zx"}));
    }
}
