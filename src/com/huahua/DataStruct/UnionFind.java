package src.com.huahua.DataStruct;

import java.util.Arrays;

/**
 * @description: 并查集
 * @author：张佳伟
 * @date: 2024/9/8
 */
public class UnionFind {

    private final int[] f, rank;

    UnionFind(int n) {
        f = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    public void union(int p, int q) {
        int pRoot = find(p), qRoot = find(q);

        if (pRoot != qRoot) {
            if (rank[qRoot] <= rank[pRoot]) {
                f[qRoot] = pRoot;
            } else {
                f[pRoot] = qRoot;
            }
            if (rank[pRoot] == f[qRoot]) {
                rank[pRoot]++;
            }
        }
    }

    public int find(int p) {
        if (f[p] == p) {
            return p;
        }
        return f[p] = find(f[p]);
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(0, 9);
        uf.union(9, 8);
        uf.union(3, 7);
        uf.union(9, 3);
        System.out.println(Arrays.toString(uf.f));
    }
}
