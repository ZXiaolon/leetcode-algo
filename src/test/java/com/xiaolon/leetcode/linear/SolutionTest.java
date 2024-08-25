package com.xiaolon.leetcode.linear;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.linear.SolutionTest
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/25
 *
 *   版权描述：
 *   公司地址：
 *
 */
class SolutionTest {

    @ParameterizedTest
    @MethodSource(value = "threeSumProvider")
    public void threeSum(int[] nums) {
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.threeSum(nums);


        for (List<Integer> list : ans){
            list.forEach(ele -> System.out.print(ele + " "));
            System.out.println();
        }
    }

    public static Stream<int[]> threeSumProvider(){
        return Stream.of(
                new int[]{-1,0,1,2,-1,-4},
                new int[]{0,1,1},
                new int[]{0,0,0}
                        );
    }
}