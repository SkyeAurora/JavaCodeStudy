package src.com.huahua.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/28
 */
public class LCR110 {
    private static class Solution {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            dfs(graph, new ArrayList<>(), 0);

            return ans;
        }

        private void dfs(int[][] graph, List<Integer> cur, int start) {
            if (graph.length - 1 == start) {
                cur.add(start);
                ans.add(new ArrayList<>(cur));
                cur.remove(cur.size() - 1);
                return;
            }
            for (int next : graph[start]) {
                cur.add(start);
                dfs(graph, cur, next);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }
}
