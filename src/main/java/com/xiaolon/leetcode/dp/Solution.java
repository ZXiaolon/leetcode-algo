/*

 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.dp.Solution
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/23
 *
 */
package com.xiaolon.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 类描述： Solution
 **/
public class Solution {

    /**
     * leetcode: 740 删除并获得点数
     * @param nums
     * @return
     */
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    /**
     * leetcode:746 使用最小花费爬楼梯
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] res = new int[n];
        res[0] = cost[0];
        res[1] = cost[1];

        for (int i = 2; i < n; i++) {
            res[i] = Math.min(res[i - 2] + cost[i], res[i - 1] + cost[i - 1]);
        }
        return Math.min(res[n - 1], res[n - 2]);

    }

    /**
     * leetcode:1137 第N个泰伯那契数
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        int[] res = new int[]{0, 1, 1};
        int i=0;
        while(i<=n){
            if(i>=3)
                res[i%3] = res[(i-1)%3] + res[(i-2)%3] + res[(i-3)%3];
            i++;
        }
        return res[n%3];
    }


}