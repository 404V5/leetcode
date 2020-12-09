package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/12/9.
 * https://leetcode-cn.com/problems/unique-paths/
 */
public class 不同路径62 {
    /**
     * 方法一：动态规划
     */
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    /**
     * 方法二：组合数学
     */
//    public int uniquePaths(int m, int n) {
//        long ans = 1;
//        for (int x = n, y = 1; y < m; ++x, ++y) {
//            ans = ans * x / y;
//        }
//        return (int) ans;
//    }

}
