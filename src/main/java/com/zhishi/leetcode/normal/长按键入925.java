package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/21.
 * https://leetcode-cn.com/problems/long-pressed-name/submissions/
 */
public class 长按键入925 {
    /**
     * 方法一：双指针
     */
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}
