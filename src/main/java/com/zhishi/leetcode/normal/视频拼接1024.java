package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/10/7.
 * https://leetcode-cn.com/problems/video-stitching/
 */
public class 视频拼接1024 {
    public int videoStitching(int[][] clips, int T) {
        //记录开始值 就是上一轮的最大结束值
        int s = 0;
        //记录结束值
        int e=0;
        int count = 0;

        while(s<=T) {
            e = 0;
            for(int j=0;j<clips.length;j++) {
                if(clips[j][0]<=s) {
                    e = Math.max(e, clips[j][1]);
                }
            }
            count++;
            if(e >= T) {
                return count;
            }
            if(e == s) {//说明已经找到当前数组的最大值了 没有更大的了 而且不满足T
                return -1;
            }
            s = e;
        }
        return -1;
    }
}
