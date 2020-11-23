package com.zhishi.leetcode.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by songpb on 2020/11/23.
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class 用最少数量的箭引爆气球452 {
    /**
     * 方法一：排序 + 贪心算法
     */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

}
