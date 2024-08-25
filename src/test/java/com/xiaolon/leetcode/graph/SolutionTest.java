package com.xiaolon.leetcode.graph;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.graph.SolutionTest
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/25
 *
 *   版权描述：
 *   公司地址：
 *
 */class SolutionTest {

    @ParameterizedTest
    @MethodSource(value = "numIslandsProvider")
    public void numIslands(char[][] grid) {
        Solution solution = new Solution();

        System.out.println(solution.numIslands(grid));
    }

    public static Stream<char[][]> numIslandsProvider() {
        return Stream.of(
                new char[][]{
                            {'1','1','1','1','0'},
                            {'1','1','0','1','0'},
                            {'1','1','0','0','0'},
                            {'0','0','0','0','0'}
                },
                new char[][]{
                    {'1','1','0','0','0'},
                    {'1','1','0','0','0'},
                    {'0','0','1','0','0'},
                    {'0','0','0','1','1'}
                }
                        );
    }
}