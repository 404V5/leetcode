package com.zhishi.leetcode.normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by songpb on 2020/11/6.
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class 根据数字二进制下1的数目排序1356 {
    /**
     * 方法一：暴力
     */
//    public int[] sortByBits(int[] arr) {
//        int[] bit = new int[10001];
//        List<Integer> list = new ArrayList<Integer>();
//        for (int x : arr) {
//            list.add(x);
//            bit[x] = get(x);
//        }
//        Collections.sort(list, new Comparator<Integer>() {
//            public int compare(Integer x, Integer y) {
//                if (bit[x] != bit[y]) {
//                    return bit[x] - bit[y];
//                } else {
//                    return x - y;
//                }
//            }
//        });
//        for (int i = 0; i < arr.length; ++i) {
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }
//
//    public int get(int x) {
//        int res = 0;
//        while (x != 0) {
//            res += x % 2;
//            x /= 2;
//        }
//        return res;
//    }

    /**
     * 方法二：递推预处理
     */
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
        }
        int[] bit = new int[10001];
        for (int i = 1; i <= 10000; ++i) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
