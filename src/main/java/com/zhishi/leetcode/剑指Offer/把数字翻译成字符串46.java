package com.zhishi.leetcode.剑指Offer;

/**
 * Created by songpb on 2020/10/7.
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class 把数字翻译成字符串46 {
    public int translateNum(int num) {
        //将字符串转化为数字
        String str = String.valueOf(num);
        //dfs遍历字符串求解
        return dfs(str, 0);
    }
    //表示从index位置开始有好多种翻译方法
    public int dfs(String str, int index){
        //如果当前的下标大于等于字符串的长度 - 1，则说明当前位置是由上一次跳到此处的，则直接返回1
        if(index >= str.length() - 1)
            return 1;
        //先求解每一次都翻译一个字符的方法数
        int res = dfs(str, index + 1);
        //以当前字符的下标为开始，截取两位，判断这位组成的数字是否在10~25之间
        //如果在这一次就可以直接翻译两个字符，然后从两个字符后面的位置开始翻译
        String temp = str.substring(index, index + 2);
        if(temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
            res += dfs(str, index + 2);
        return res;
    }
}
