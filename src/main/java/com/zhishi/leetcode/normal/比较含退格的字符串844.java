package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/19.
 * https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class 比较含退格的字符串844 {
    /**
     * 方法一：重构字符串
     */
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String str) {
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            char ch = str.charAt(i);
            if (ch != '#') {
                ret.append(ch);
            } else {
                if (ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }

    /**
     * 方法二：双指针
     */
//    public boolean backspaceCompare(String S, String T) {
//        int i = S.length() - 1, j = T.length() - 1;
//        int skipS = 0, skipT = 0;
//
//        while (i >= 0 || j >= 0) {
//            while (i >= 0) {
//                if (S.charAt(i) == '#') {
//                    skipS++;
//                    i--;
//                } else if (skipS > 0) {
//                    skipS--;
//                    i--;
//                } else {
//                    break;
//                }
//            }
//            while (j >= 0) {
//                if (T.charAt(j) == '#') {
//                    skipT++;
//                    j--;
//                } else if (skipT > 0) {
//                    skipT--;
//                    j--;
//                } else {
//                    break;
//                }
//            }
//            if (i >= 0 && j >= 0) {
//                if (S.charAt(i) != T.charAt(j)) {
//                    return false;
//                }
//            } else {
//                if (i >= 0 || j >= 0) {
//                    return false;
//                }
//            }
//            i--;
//            j--;
//        }
//        return true;
//    }
}
