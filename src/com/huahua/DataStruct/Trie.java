package src.com.huahua.DataStruct;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/1
 */
public class Trie {
    private final Trie[] next;
    private boolean isEnd;

    Trie() {
        next = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] != null) {
                node.next[c - 'a'] = new Trie();
            }
            node = node.next[c - 'a'];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] != null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return node.isEnd;
    }

    public boolean isPrefix(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            if (node.next[c - 'a'] != null) {
                return false;
            }
            node = node.next[c - 'a'];
        }
        return true;
    }
}
