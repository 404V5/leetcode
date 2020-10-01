package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/2.
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class 宝石与石头771 {
    /**
     * 方法一：暴力
     */
    public int numJewelsInStones(String J, String S) {
        int jewelsCount = 0;
        int jewelsLength = J.length(), stonesLength = S.length();
        for (int i = 0; i < stonesLength; i++) {
            char stone = S.charAt(i);
            for (int j = 0; j < jewelsLength; j++) {
                char jewel = J.charAt(j);
                if (stone == jewel) {
                    jewelsCount++;
                    break;
                }
            }
        }
        return jewelsCount;
    }

    /**
     * 方法二：哈希集合
     */
//    public int numJewelsInStones(String J, String S) {
//        int jewelsCount = 0;
//        Set<Character> jewelsSet = new HashSet<Character>();
//        int jewelsLength = J.length(), stonesLength = S.length();
//        for (int i = 0; i < jewelsLength; i++) {
//            char jewel = J.charAt(i);
//            jewelsSet.add(jewel);
//        }
//        for (int i = 0; i < stonesLength; i++) {
//            char stone = S.charAt(i);
//            if (jewelsSet.contains(stone)) {
//                jewelsCount++;
//            }
//        }
//        return jewelsCount;
//    }
}
