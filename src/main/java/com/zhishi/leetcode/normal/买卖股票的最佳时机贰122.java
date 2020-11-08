package com.zhishi.leetcode.normal;

/**
 * Created by songpb on 2020/11/8.
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class 买卖股票的最佳时机贰122 {
    /**
     * 方法一：动态规划
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    /**
     * 方法二：贪心
     */
//    public int maxProfit(int[] prices) {
//        int ans = 0;
//        int n = prices.length;
//        for (int i = 1; i < n; ++i) {
//            ans += Math.max(0, prices[i] - prices[i - 1]);
//        }
//        return ans;
//    }

}

