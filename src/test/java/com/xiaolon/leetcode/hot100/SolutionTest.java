package com.xiaolon.leetcode.hot100;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.hot100.SolutionTest
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/28
 *
 *   版权描述：
 *   公司地址：
 *
 */class SolutionTest {

    @ParameterizedTest
    @MethodSource(value = "twoSumProvider")
    public void twoSum(int[] nums, int target) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }

    public static Stream<Arguments> twoSumProvider() {
        return Stream.of(
                Arguments.of(new int[]{2,7,11,15}, 9),
                Arguments.of(new int[]{3,2,4}, 6),
                Arguments.of(new int[]{3,3}, 6)
                        );

    }

    @ParameterizedTest
    @MethodSource(value = "orangesRottingProvider")
    void orangesRotting(int[][] grid) {
        Solution solution = new Solution();
        System.out.println(solution.orangesRotting(grid));
    }

    public static Stream<int[][]> orangesRottingProvider() {
        return Stream.of(
                new int[][]{{2,1,1},{1,1,0},{0,1,1}},
                new int[][]{{2,1,1},{0,1,1},{1,0,1}},
                new int[][]{{0,2}}
            );
    }

    @ParameterizedTest
    @MethodSource(value = "longestConsecutiveProvider")
    public void longestConsecutive(int[] nums) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }
    public static Stream<int[]> longestConsecutiveProvider() {
        return Stream.of(
                new int[]{100,4,200,1,3,2},
                new int[]{0,3,7,2,5,8,4,6,0,1},
                new int[]{1,2,0,1}
        );
    }

    @ParameterizedTest
    @MethodSource(value = "groupAnagramsProvider")
    public void groupAnagrams(String[] strs) {
        Solution solution = new Solution();
        for (List<String> group : solution.groupAnagrams(strs)) {
            System.out.print("[");
            group.forEach(ele-> System.out.print(ele));
            System.out.print("]");
        }
    }
    public static Stream<String[]> groupAnagramsProvider() {
        return Stream.of(
                new String[]{"eat","tea","tan","ate","nat","bat"},
                new String[]{" "},
                new String[]{"a"}
        );
    }
}