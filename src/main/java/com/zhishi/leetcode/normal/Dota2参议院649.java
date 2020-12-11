package com.zhishi.leetcode.normal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by songpb on 2020/12/11.
 * https://leetcode-cn.com/problems/dota2-senate/
 */
public class Dota2参议院649 {
    /**
     * 方法一：「循环」队列
     */
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int radiantIndex = radiant.poll(), direIndex = dire.poll();
            if (radiantIndex < direIndex) {
                radiant.offer(radiantIndex + n);
            } else {
                dire.offer(direIndex + n);
            }
        }
        return !radiant.isEmpty() ? "Radiant" : "Dire";
    }
}
