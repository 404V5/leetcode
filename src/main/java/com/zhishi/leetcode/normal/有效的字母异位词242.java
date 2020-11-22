package com.zhishi.leetcode.normal;

import java.util.Arrays;

/**
 * Created by songpb on 2020/11/22.
 * https://leetcode-cn.com/problems/valid-anagram/
 */
public class 有效的字母异位词242 {
    /**
     * 方法一：排序
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
    /**
     * 方法二：哈希表
     */

//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        Map<Character, Integer> table = new HashMap<Character, Integer>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            table.put(ch, table.getOrDefault(ch, 0) + 1);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            char ch = t.charAt(i);
//            table.put(ch, table.getOrDefault(ch, 0) - 1);
//            if (table.get(ch) < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
