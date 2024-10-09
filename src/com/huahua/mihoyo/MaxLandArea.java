package src.com.huahua.mihoyo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description: 最大陆地区域
 * 在一张 n*m 的地图上，分为陆地块与海洋块，边相邻的相同块成为连通区域，地图上有连通起来的陆地区域与海洋区域，
 * 现在我可以使一片海洋变为陆地，求变化后最大的陆地区域的面积是多少
 * @author：张佳伟
 * @date: 2024/9/8
 */
public class MaxLandArea {

    private int[][] map;
    private int n, m;
    private final int[] dirs = new int[]{1, 0, -1, 0, 1};


    public int maxLandArea(int[][] map) {
        this.map = map;
        this.m = map.length;
        this.n = map[0].length;

        // 为陆地编号 同时有 visited 数组的作用（搜索到节点改变值，!= 0就说明被访问过）
        int[][] regionId = new int[m][n];
        // 对应编号陆地的面积
        int[] regionArea = new int[m * n + 1];
        // 编号下标
        int regionIndex = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 未被访问的陆地
                if (map[i][j] == 1 && regionId[i][j] == 0) {
                    regionArea[regionIndex] = dfs(i, j, regionId, regionIndex);
                    regionIndex++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0 && regionId[i][j] != -1) {
                    // list 存放与当前 sea 相连的陆地区域id
                    Set<Integer> neighbourNodeSet = new HashSet<>();
                    int area = dfs(i, j, regionId, neighbourNodeSet);
                    for (int id : neighbourNodeSet) {
                        area += regionArea[id];
                        ans = Math.max(ans, area);
                    }
                }
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] regionId, Set<Integer> set) {
        if (i >= 0 && i < m && j >= 0 && j < n && map[i][j] == 1) {
            set.add(regionId[i][j]);
        }
        if (i < 0 || i >= m || j < 0 || j >= n || map[i][j] == 1 || regionId[i][j] != 0) {
            return 0;
        }
        int area = 1;
        regionId[i][j] = -1;
        for (int d = 1; d < 5; d++) {
            area += dfs(i + dirs[d - 1], j + dirs[d], regionId, set);
        }
        return area;
    }

    private int dfs(int i, int j, int[][] regionId, int regionIndex) {
        if (i < 0 || i >= m || j < 0 || j >= n || map[i][j] == 0 || regionId[i][j] != 0) {
            return 0;
        }
        int area = 1;
        regionId[i][j] = regionIndex;
        for (int d = 1; d < 5; d++) {
            area += dfs(i + dirs[d - 1], j + dirs[d], regionId, regionIndex);
        }
        return area;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int[][] map = new int[m][n];
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String line = in.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) == '0' ? 0 : 1;
            }
        }
        MaxLandArea solve = new MaxLandArea();
        System.out.println(solve.maxLandArea(map));
    }
}
