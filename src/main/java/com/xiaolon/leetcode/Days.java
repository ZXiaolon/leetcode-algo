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