/*
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.Days
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/21
 */
package com.xiaolon.leetcode;

import lombok.val;

/**
 * 类描述： Days
 **/
public class Days {


    /**
     * leetcode 2708 一个小组的最大实力值
     * @param nums
     * @return
     */
    public long maxStrength(int[] nums) {
        return 0l;
    }

    /**
     * leetcode 1450. 在既定时间做作业的学生人数
     * @param startTime
     * @param endTime
     * @param queryTime
     * @return
     */
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        int n = startTime.length;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }

    /**
     * leetcode 2024 考试的最大困扰度
     * @param answerKey
     * @param k
     * @return
     */
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // 正确解法1：滑动窗口
        // 正确解法2：双指针，创建2个变量分别记录T与F的个数，区间类2个char的数量不能都超过k
        return Math.max(maxConsecutiveChar(answerKey, k, 'T'), maxConsecutiveChar(answerKey, k, 'F'));
    }

    /**
     * 滑动窗口求解最长连续字串
     * @param answerKey
     * @param k
     * @param ch
     * @return
     */
    public int maxConsecutiveChar(String answerKey, int k, char ch){
        int ans=0;
        int n=answerKey.length();
        for (int left=0, right = 0, sum=0; right < n; right++) {
            sum += answerKey.charAt(right) != ch ?1 : 0;
            while(sum>k){
                sum -= answerKey.charAt(left++) != ch ?1 :0;
            }
            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }

    /**
     * leetcode: 3127. 构造相同颜色的正方形
     * @param grid
     * @return
     */
    public boolean canMakeSquare(char[][] grid) {
        // 1. 暴力解法，一次遍历gird矩阵。改变颜色，并判断周围颜色
        // 2. 滑动窗口，创建2*2小窗口，并滑动。判断窗口内是否存在3个颜色相同方块；
        int m = grid.length;
        int n = grid[0].length;
        char[] temp = new char[4];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                temp[0] = grid[i][j];
                temp[1] = grid[i][j-1];
                temp[2] = grid[i-1][j];
                temp[3] = grid[i-1][j-1];
                // 若包含3个相同字符，则返回true

                int count=0;
                for (char c : temp) {
                    count += (c&1);
                }
                if(count!=2) return true;

            }
        }
        return false;
    }
}