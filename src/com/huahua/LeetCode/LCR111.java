package src.com.huahua.LeetCode;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/28
 */
public class LCR111 {
    class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }

    private class Solution {
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            int nvars = 0;
            Map<String, Integer> vars = new HashMap<>();
            for (List<String> equation : equations) {
                if (!vars.containsKey(equation.get(0))) {
                    vars.put(equation.get(0), nvars++);
                }
                if (!vars.containsKey(equation.get(1))) {
                    vars.put(equation.get(1), nvars++);
                }
            }
            List<Pair>[] edges = new List[nvars];
            for (int i = 0; i < nvars; i++) {
                edges[i] = new ArrayList<>();
            }
            for (int i = 0; i < values.length; i++) {
                int va = vars.get(equations.get(i).get(0)), vb = vars.get(equations.get(i).get(1));
                edges[va].add(new Pair(vb, values[i]));
                edges[vb].add(new Pair(va, 1.0 / values[i]));
            }
            double[] ans = new double[queries.size()];
            Arrays.fill(ans, -1);
            for (int i = 0; i < queries.size(); i++) {
                if (!vars.containsKey(queries.get(i).get(0)) || !vars.containsKey(queries.get(i).get(1))) {
                    ans[i] = -1.0;
                    continue;
                }
                int va = vars.get(queries.get(i).get(0)), vb = vars.get(queries.get(i).get(1));
                dfs(edges, va, vb, 1, new HashSet<>(), i, ans);
            }

            return ans;
        }

        private void dfs(List<Pair>[] edges, int start, int end, double cur, Set<Integer> set, int i, double[] ans) {
            if (start == end) {
                ans[i] = cur;
                return;
            }
            for (Pair pair : edges[start]) {
                if (set.contains(pair.index)) {
                    continue;
                }
                set.add(start);
                dfs(edges, pair.index, end, cur * pair.value, set, i, ans);
                set.remove(start);
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        equations.add(Arrays.asList("c", "d"));
        equations.add(Arrays.asList("d", "e"));

        double[] values = new double[]{3.0, 4.0, 5.0, 6.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("b", "d"));

        System.out.println(Arrays.toString(new LCR111().new Solution().calcEquation(equations, values, queries)));
    }
}
