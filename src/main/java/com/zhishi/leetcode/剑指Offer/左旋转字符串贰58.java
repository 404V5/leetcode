package com.zhishi.leetcode.剑指Offer;

/**
 * Created by songpb on 2020/9/12.
 * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 */
public class 左旋转字符串贰58 {
    /**
     * 方法一 字符串切片
     */
    private String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
    /**
     * 方法二 列表遍历拼接
     */
//    public String reverseLeftWords(String s, int n) {
//        StringBuilder res = new StringBuilder();
//        for(int i = n; i < s.length(); i++)
//            res.append(s.charAt(i));
//        for(int i = 0; i < n; i++)
//            res.append(s.charAt(i));
//        return res.toString();
//    }

    /**
     * 方法三 字符串遍历拼接
     */
//    public String reverseLeftWords(String s, int n) {
//        String res = "";
//        for(int i = n; i < s.length(); i++)
//            res += s.charAt(i);
//        for(int i = 0; i < n; i++)
//            res += s.charAt(i);
//        return res;
//    }
    public static void main(String[] args) {
        左旋转字符串贰58 test = new 左旋转字符串贰58();
        System.out.println(test.reverseLeftWords("abcdefg", 2));
    }
}
