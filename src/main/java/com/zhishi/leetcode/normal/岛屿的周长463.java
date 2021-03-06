package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/30.
 * https://leetcode-cn.com/problems/island-perimeter/
 */
public class 岛屿的周长463 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    /**
     * 方法一：迭代
     */
//    public int islandPerimeter(int[][] grid) {
//        int n = grid.length, m = grid[0].length;
//        int ans = 0;
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < m; ++j) {
//                if (grid[i][j] == 1) {
//                    int cnt = 0;
//                    for (int k = 0; k < 4; ++k) {
//                        int tx = i + dx[k];
//                        int ty = j + dy[k];
//                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
//                            cnt += 1;
//                        }
//                    }
//                    ans += cnt;
//                }
//            }
//        }
//        return ans;
//    }
    /**
     * 方法二：深度优先搜索
     */

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, n, m);
                }
            }
        }
        return ans;
    }

    public int dfs(int x, int y, int[][] grid, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0) {
            return 1;
        }
        if (grid[x][y] == 2) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 0;
        for (int i = 0; i < 4; ++i) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            res += dfs(tx, ty, grid, n, m);
        }
        return res;
    }

}
