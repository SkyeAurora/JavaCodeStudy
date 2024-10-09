package src.com.huahua.meituan;

import java.util.*;

/**
 * @description:
 * @author：张佳伟
 * @date: 2024/8/9
 */
public class Test4 {

    static Map<Integer, Integer> fa = new HashMap<>();

    public static int find(int x) {
        if (fa.get(x) == x) {
            return x;
        }
        int parent = find(fa.get(x));
        fa.put(x, parent);
        return parent;
    }

    public static void unionSet(int x, int y) {
        fa.put(find(x), find(y));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), m = in.nextInt(), q = in.nextInt();
        int[] union = new int[n + 1];
        HashSet<String> uv = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            union[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            uv.add(u + "," + v);
            for (int j = 0; j <= n; j++) {
                if (union[j] == union[u]) {
                    union[j] = union[v];
                }
            }
        }

        for (int i = 0; i < q; i++) {
            int op = in.nextInt(), u = in.nextInt(), v = in.nextInt();
            if (op == 1 && union[u] != union[v]) {

            } else if (op == 2) {

            }
        }
    }
}
