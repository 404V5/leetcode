package com.zhishi.leetcode.normal;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by songpb on 2020/11/9.
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */
public class 最接近原点的K个点973 {
    /**
     * 方法一：排序
     */
//    public int[][] kClosest(int[][] points, int K) {
//        Arrays.sort(points, new Comparator<int[]>() {
//            public int compare(int[] point1, int[] point2) {
//                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
//            }
//        });
//        return Arrays.copyOfRange(points, 0, K);
//    }
    /**
     * 方法二：优先队列
     */
//    public int[][] kClosest(int[][] points, int K) {
//        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
//            public int compare(int[] array1, int[] array2) {
//                return array2[0] - array1[0];
//            }
//        });
//        for (int i = 0; i < K; ++i) {
//            pq.offer(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
//        }
//        int n = points.length;
//        for (int i = K; i < n; ++i) {
//            int dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
//            if (dist < pq.peek()[0]) {
//                pq.poll();
//                pq.offer(new int[]{dist, i});
//            }
//        }
//        int[][] ans = new int[K][2];
//        for (int i = 0; i < K; ++i) {
//            ans[i] = points[pq.poll()[1]];
//        }
//        return ans;
//    }
    /**
     * 方法三：快速选择（快速排序的思想）
     */
    Random rand = new Random();

    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        random_select(points, 0, n - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void random_select(int[][] points, int left, int right, int K) {
        int pivotId = left + rand.nextInt(right - left + 1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points, right, pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0] * points[j][0] + points[j][1] * points[j][1];
            if (dist <= pivot) {
                ++i;
                swap(points, i, j);
            }
        }
        ++i;
        swap(points, i, right);
        // [left, i-1] 都小于等于 pivot, [i+1, right] 都大于 pivot
        if (K < i - left + 1) {
            random_select(points, left, i - 1, K);
        } else if (K > i - left + 1) {
            random_select(points, i + 1, right, K - (i - left + 1));
        }
    }

    public void swap(int[][] points, int index1, int index2) {
        int[] temp = points[index1];
        points[index1] = points[index2];
        points[index2] = temp;
    }
}
