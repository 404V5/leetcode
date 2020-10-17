package com.zhishi.leetcode.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by songpb on 2020/10/17.
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class N皇后贰52 {
    /**
     * 方法一：基于集合的回溯
     */
    public int totalNQueens(int n) {
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        return backtrack(n, 0, columns, diagonals1, diagonals2);
    }

    public int backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                count += backtrack(n, row + 1, columns, diagonals1, diagonals2);
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
            return count;
        }
    }
    /**
     * 方法二：基于位运算的回溯
     */

//    public int totalNQueens(int n) {
//        return solve(n, 0, 0, 0, 0);
//    }
//
//    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
//        if (row == n) {
//            return 1;
//        } else {
//            int count = 0;
//            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
//            while (availablePositions != 0) {
//                int position = availablePositions & (-availablePositions);
//                availablePositions = availablePositions & (availablePositions - 1);
//                count += solve(n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
//            }
//            return count;
//        }
//    }
}