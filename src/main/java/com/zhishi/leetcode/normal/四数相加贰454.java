package com.zhishi.leetcode.normal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by songpb on 2020/11/27.
 * https://leetcode-cn.com/problems/4sum-ii/
 */
public class 四数相加贰454 {
    /**
     * 方法一：分组 + 哈希表
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }
}
