/*
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.Days
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/21
 */
package com.xiaolon.leetcode;
import java.net.Socket;
import java.util.*;

/**
 * 类描述： Days
 **/
public class Days {

    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int edgeScore(int[] edges) {
        int n = edges.length;
        long[] score = new long[n];
        for (int i = 0; i < n; i++) {
            int to = edges[i];
            score[to] += i;
        }

        long maxScore = -1;
        int loc = -1;

        for (int i = 0; i < n; i++) {
            if(score[i] > maxScore){
                maxScore = score[i];
                loc = i;
            }
        }

        return loc;
    }

    /**
     * leetcode 2376 统计特殊整数
     * @param n
     * @return
     */
    public int countSpecialNumbers(int n) {
        // 解决思路：动态规划
        String nStr = String.valueOf(n);
        int res = 0;
        int prod = 9;
        for (int i = 0; i < nStr.length() - 1; i++) {
            res += prod;
            prod *= 9 - i;
        }
        res += dp(0, false, nStr);
        return res;

    }
    public int dp(int mask, boolean prefixSmaller, String nStr) {
        if (Integer.bitCount(mask) == nStr.length()) {
            return 1;
        }
        int key = mask * 2 + (prefixSmaller ? 1 : 0);
        if (!memo.containsKey(key)) {
            int res = 0;
            int lowerBound = mask == 0 ? 1 : 0;
            int upperBound = prefixSmaller ? 9 : nStr.charAt(Integer.bitCount(mask)) - '0';
            for (int i = lowerBound; i <= upperBound; i++) {
                if (((mask >> i) & 1) == 0) {
                    res += dp(mask | (1 << i), prefixSmaller || i < upperBound, nStr);
                }
            }
            memo.put(key, res);
        }
        return memo.get(key);
    }

    /**
     * leetcode 2414  最长的字母序连续子字符串的长度
     * @param s
     * @return
     */
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        int n = s.length();
        int currLen = 1;
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) - s.charAt(i - 1) == 1) {
                currLen++;
                ans = currLen > ans ? currLen: ans;
            }else{
                currLen = 1;
            }
        }
        return ans;
    }

    /**
     * leetcode 2708 一个小组的最大实力值
     * @param nums
     * @return
     */
    public long maxStrength(int[] nums) {
        long ans=1;
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            if(num>0) {
                ans = ans==0? num : ans*num;
            }
            else if(num<0) list.add(num);

        }
        int n = list.size();
        Collections.sort(list);

        int i = 0;
        while(n-i>=2){
            ans*=list.get(i++);
            ans*=list.get(i++);
        }

        return ans;
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