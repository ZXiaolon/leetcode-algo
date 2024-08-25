/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.linear.Solution
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/24
 *
 */
package com.xiaolon.leetcode.linear;

import lombok.val;
import net.bytebuddy.TypeCache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类描述： Solution
 **/
public class Solution {


    /**
     * leetcode: 15 三数之和
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int first = 0; first <n ; first++) {
            if(first>0 && nums[first] == nums[first-1]){
                continue;
            }
            int third = n-1;
            int target = -nums[first];

            for (int second = first+1; second <n ; second++) {
                if(second > first+1 && nums[second] == nums[second-1]) {
                    continue;
                }
                while(second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                if(second == third) break;
                if(nums[second] + nums[third] == target) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}