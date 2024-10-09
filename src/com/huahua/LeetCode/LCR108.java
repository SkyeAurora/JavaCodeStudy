package src.com.huahua.LeetCode;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/20
 */
public class LCR108 {
    private static class Solution {
        HashMap<String, Integer> wordMap = new HashMap<>();
        List<List<Integer>> edge = new ArrayList<>();
        int index = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            for (String word : wordList) {
                addEdge(word);
            }
            addEdge(beginWord);
            if (!wordMap.containsKey(endWord)) {
                return 0;
            }
            int[] dis = new int[index];
            Arrays.fill(dis, Integer.MAX_VALUE);
            int beginId = wordMap.get(beginWord), endId = wordMap.get(endWord);
            dis[beginId] = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(beginId);
            while (!queue.isEmpty()) {
                int x = queue.poll();
                if (x == endId) {
                    return dis[endId] / 2 + 1;
                }
                for (int i : edge.get(x)) {
                    if (dis[i] == Integer.MAX_VALUE) {
                        dis[i] = dis[x] + 1;
                        queue.offer(i);
                    }
                }
            }
            return 0;
        }

        private void addWord(String word) {
            if (!wordMap.containsKey(word)) {
                wordMap.put(word, index++);
                edge.add(new ArrayList<>());
            }
        }

        private void addEdge(String word) {
            addWord(word);
            int id1 = wordMap.get(word);
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++) {
                char temp = array[i];
                array[i] = '*';
                String newWord = new String(array);
                addWord(newWord);
                int id2 = wordMap.get(newWord);
                edge.get(id1).add(id2);
                edge.get(id2).add(id1);
                array[i] = temp;
            }
        }
    }

    public static void main(String[] args) {

    }
}
