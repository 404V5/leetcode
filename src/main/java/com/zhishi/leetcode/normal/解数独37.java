package com.zhishi.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songpb on 2020/9/15.
 * https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode-solution/
 */
public class 解数独37 {

//    private boolean[][] line = new boolean[9][9];
//    private boolean[][] column = new boolean[9][9];
//    private boolean[][][] block = new boolean[3][3][9];
//    private boolean valid = false;
//    private List<int[]> spaces = new ArrayList<int[]>();
//
//    /**
//     * 方法一 递归
//     * @param board
//     */
//    public void solveSudoku(char[][] board) {
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] == '.') {
//                    spaces.add(new int[]{i, j});
//                } else {
//                    int digit = board[i][j] - '0' - 1;
//                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
//                }
//            }
//        }
//
//        dfs(board, 0);
//    }
//
//    public void dfs(char[][] board, int pos) {
//        if (pos == spaces.size()) {
//            valid = true;
//            return;
//        }
//
//        int[] space = spaces.get(pos);
//        int i = space[0], j = space[1];
//        for (int digit = 0; digit < 9 && !valid; ++digit) {
//            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
//                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
//                board[i][j] = (char) (digit + '0' + 1);
//                dfs(board, pos + 1);
//                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
//            }
//        }
//    }

//    private int[] line = new int[9];
//    private int[] column = new int[9];
//    private int[][] block = new int[3][3];
//    private boolean valid = false;
//    private List<int[]> spaces = new ArrayList<int[]>();
//
//    /**
//     * 方法二 位运算优化
//     * @param board
//     */
//    public void solveSudoku(char[][] board) {
//        for (int i = 0; i < 9; ++i) {
//            for (int j = 0; j < 9; ++j) {
//                if (board[i][j] == '.') {
//                    spaces.add(new int[]{i, j});
//                } else {
//                    int digit = board[i][j] - '0' - 1;
//                    flip(i, j, digit);
//                }
//            }
//        }
//
//        dfs(board, 0);
//    }
//
//    public void dfs(char[][] board, int pos) {
//        if (pos == spaces.size()) {
//            valid = true;
//            return;
//        }
//
//        int[] space = spaces.get(pos);
//        int i = space[0], j = space[1];
//        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
//        for (; mask != 0 && !valid; mask &= (mask - 1)) {
//            int digitMask = mask & (-mask);
//            int digit = Integer.bitCount(digitMask - 1);
//            flip(i, j, digit);
//            board[i][j] = (char) (digit + '0' + 1);
//            dfs(board, pos + 1);
//            flip(i, j, digit);
//        }
//    }
//
//    public void flip(int i, int j, int digit) {
//        line[i] ^= (1 << digit);
//        column[j] ^= (1 << digit);
//        block[i / 3][j / 3] ^= (1 << digit);
//    }

    private int[] line = new int[9];
    private int[] column = new int[9];
    private int[][] block = new int[3][3];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<>();

    /**
     * 方法三 枚举优化
     *
     * @param board 二维字符数组
     */
    private void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int digit = board[i][j] - '0' - 1;
                    flip(i, j, digit);
                }
            }
        }

        while (true) {
            boolean modified = false;
            for (int i = 0; i < 9; ++i) {
                for (int j = 0; j < 9; ++j) {
                    if (board[i][j] == '.') {
                        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
                        if ((mask & (mask - 1)) == 0) {
                            int digit = Integer.bitCount(mask - 1);
                            flip(i, j, digit);
                            board[i][j] = (char) (digit + '0' + 1);
                            modified = true;
                        }
                    }
                }
            }
            if (!modified) {
                break;
            }
        }

        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                }
            }
        }

        dfs(board, 0);
    }

    private void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(line[i] | column[j] | block[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !valid; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flip(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flip(i, j, digit);
        }
    }

    private  void flip(int i, int j, int digit) {
        line[i] ^= (1 << digit);
        column[j] ^= (1 << digit);
        block[i / 3][j / 3] ^= (1 << digit);
    }

    //[["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
    public static void main(String[] args) {
        解数独37 test = new 解数独37();
    }
}
