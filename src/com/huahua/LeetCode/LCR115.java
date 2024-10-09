package src.com.huahua.LeetCode;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/9/5
 */
public class LCR115 {
    private static class Solution {
        public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
            Map<Integer, List<Integer>> edges = new HashMap<>();
            int[] inDegree = new int[nums.length];

            for (int[] sequence : sequences) {
                for (int i = 1; i < sequence.length; i++) {
                    List<Integer> list = edges.getOrDefault(sequence[i], new ArrayList<>());
                    list.add(sequence[i - 1]);
                    edges.put(sequence[i], list);
                    inDegree[sequence[i - 1]]++;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
            while (!queue.isEmpty()) {
                if (queue.size() > 1) {
                    return false;
                }
                int x = queue.poll();
                List<Integer> next = edges.get(x);
                if (next == null) {
                    continue;
                }
                for (int n : next) {
                    inDegree[n]--;
                    if (inDegree[n] == 0) {
                        queue.offer(n);
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().sequenceReconstruction(new int[]{1, 2, 3}, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
    }
}
