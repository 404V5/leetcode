package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/8.
 * https://leetcode-cn.com/problems/reverse-string/
 */
public class 反转字符串344 {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }
}
