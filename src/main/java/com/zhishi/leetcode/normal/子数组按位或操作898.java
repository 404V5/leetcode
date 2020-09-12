package com.zhishi.leetcode.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by songpb on 2020/9/12.
 * https://leetcode-cn.com/problems/bitwise-ors-of-subarrays/
 */
public class 子数组按位或操作898 {
    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> ans = new HashSet();
        Set<Integer> cur = new HashSet();
        cur.add(0);
        for (int x : A) {
            Set<Integer> cur2 = new HashSet();
            for (int y : cur)
                cur2.add(x | y);
            cur2.add(x);
            cur = cur2;
            ans.addAll(cur);
        }

        return ans.size();
    }

    public static void main(String[] args) {
        子数组按位或操作898 test = new 子数组按位或操作898();
        System.out.println(test.subarrayBitwiseORs(new int[]{1, 1, 1, 2}));
    }
}
