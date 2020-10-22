package com.zhishi.leetcode.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songpb on 2020/10/22.
 * https://leetcode-cn.com/problems/partition-labels/
 */
public class 划分字母区间763 {
    /**
     * 方法一：贪心算法 + 双指针
     */
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
