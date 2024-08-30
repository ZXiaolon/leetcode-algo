/*
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.hot100.Solution
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/28
 *
 */
package com.xiaolon.leetcode.hot100;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 类描述： Solution
 **/
public class Solution {

    /**
     * leetcode: 108 有序数组->平衡 二叉搜索树
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return null;
    }
    /**
     * leetcode 160 相交链表
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }


    /**
     * leetcode: 1 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 最坏情况暴力解法，时间复杂度on2
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }else map.put(nums[i], i);
        }

        return ans;
    }

    /**
     * leetcode 994 腐烂的橘子
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int ans=-1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int freshed=0;
        Deque<int[]> rotten = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j]==1) {
                    freshed++;
                }
                if(grid[i][j]==2) {
                    rotten.offer(new int[]{i,j});
                }
            }
        }

        if(freshed==0) return 0;
        int mins=0;
        while(!rotten.isEmpty()) {
            int size = rotten.size();
            for(int i=0; i<size; i++) {
                int[] loc = rotten.poll();
                for (int[] dir : dirs) {
                    int x = loc[0] + dir[0];
                    int y = loc[1] + dir[1];
                    if (x>=0 && x<m && y>=0 && y<n && grid[x][y]==1) {
                        grid[x][y] = 2;
                        freshed--;
                        rotten.offer(new int[]{x,y});
                    }
                }
            }
            mins++;
        }


        if(freshed>0) return -1;
        return --mins;
    }
}