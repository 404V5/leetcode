package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/12/15.
 * https://leetcode-cn.com/problems/monotone-increasing-digits/
 */
public class 单调递增的数字738 {
    /**
     * 方法一：贪心
     */
    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }
}
