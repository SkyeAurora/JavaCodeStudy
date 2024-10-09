package src.com.huahua.LeetCode;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/31
 */
public class LCR113 {
    private static class Solution {
        // 图
        List<List<Integer>> edges;
        // 入度
        int[] indegree;
        // 结果
        int[] result;
        // 结果下标
        int index;

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            indegree = new int[numCourses];
            result = new int[numCourses];
            index = 0;
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }

            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
                indegree[info[0]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int u = queue.poll();
                result[index++] = u;
                for(int x : edges.get(u)){
                    indegree[x]--;
                    if(indegree[x] == 0){
                        queue.offer(x);
                    }
                }
            }
            if(index != numCourses){
                return new int[0];
            }

            return result;
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{{1, 0}})));
    }
}
