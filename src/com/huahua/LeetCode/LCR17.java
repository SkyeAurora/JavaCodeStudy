package src.com.huahua.LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LCR17 {

    public static void main(String[] args) {
        System.out.println(Solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    class Solution {
        private static HashMap<Character, Integer> sMap = new HashMap<>();
        private static HashMap<Character, Integer> tMap = new HashMap<>();

        public static String minWindow(String s, String t) {
            int sLen = s.length();
            int tLen = t.length();
            if (sLen < tLen || tLen == 0) {
                return "";
            }
            for (int i = 0; i < tLen; i++) {
                tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            }
            int l = 0, r = -1;
            int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
            while (r < sLen) {
                r++;
                if(r < sLen && tMap.containsKey(s.charAt(r))){
                    sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
                }
                while (l < r && check()) {
                    if (r - l + 1 < len) {
                        len = r - l + 1;
                        ansL = l;
                        ansR = l + len;
                    }
                    if(tMap.containsKey(s.charAt(l))){
                        sMap.put(s.charAt(l), sMap.getOrDefault(s.charAt(l), 0) - 1);
                    }
                    l++;
                }
            }
            return ansL == -1 ? "" : s.substring(ansL, ansR);
        }

        private static boolean check() {
            for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
                if (!sMap.containsKey(entry.getKey()) || sMap.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }
    }
}
