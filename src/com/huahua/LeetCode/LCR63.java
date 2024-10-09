package src.com.huahua.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/1
 */
public class LCR63 {
    class Trie {
        Trie[] children;
        boolean isEnd;

        Trie() {
            children = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie trie = this;
            for (char c : word.toCharArray()) {
                if (trie.children[c - 'a'] == null) {
                    trie.children[c - 'a'] = new Trie();
                }
                trie = trie.children[c - 'a'];
            }
            trie.isEnd = true;
        }

        public String hasPrefix(String word) {
            Trie trie = this;
            String ans = "";
            for (char c : word.toCharArray()) {
                if (trie.isEnd) {
                    return ans;
                }
                if (trie.children[c - 'a'] == null) {
                    return null;
                }
                ans += c;
                trie = trie.children[c - 'a'];
            }
            return null;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        // 初始化dictionary字典的前缀树
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        String[] words = sentence.split(" ");
        String ans = "";
        for (String word : words) {
            if (trie.hasPrefix(word) != null) {
                ans += trie.hasPrefix(word);
            } else {
                ans += word;
            }
            ans += " ";
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LCR63().replaceWords(new ArrayList<>(Arrays.asList("cat","bat","rat")), "the cattle was rattled by the battery"));
    }
}
