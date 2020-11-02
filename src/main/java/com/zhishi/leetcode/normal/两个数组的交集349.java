package com.zhishi.leetcode.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by songpb on 2020/11/2.
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class 两个数组的交集349 {
    /**
     * 方法一：两个集合
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            set2.add(num);
        }
        return getIntersection(set1, set2);
    }

    public int[] getIntersection(Set<Integer> set1, Set<Integer> set2) {
        if (set1.size() > set2.size()) {
            return getIntersection(set2, set1);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int num : set1) {
            if (set2.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersection = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersection[index++] = num;
        }
        return intersection;
    }
    /**
     * 方法二：排序 + 双指针
     */
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int length1 = nums1.length, length2 = nums2.length;
//        int[] intersection = new int[length1 + length2];
//        int index = 0, index1 = 0, index2 = 0;
//        while (index1 < length1 && index2 < length2) {
//            int num1 = nums1[index1], num2 = nums2[index2];
//            if (num1 == num2) {
//                // 保证加入元素的唯一性
//                if (index == 0 || num1 != intersection[index - 1]) {
//                    intersection[index++] = num1;
//                }
//                index1++;
//                index2++;
//            } else if (num1 < num2) {
//                index1++;
//            } else {
//                index2++;
//            }
//        }
//        return Arrays.copyOfRange(intersection, 0, index);
//    }
}
