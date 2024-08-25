package com.xiaolon.leetcode.dp;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.dp.SolutionTest
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/23
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */class SolutionTest {

    @ParameterizedTest
    @ValueSource(ints = {4,25})
    void tribonacci(int n) {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(n));
    }

    @ParameterizedTest
    @MethodSource(value = "costProvider")
    void minCostClimbingStairs(int[] cost) {
        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));
    }

    public static Stream<int[]> costProvider(){
        return Stream.of(
                new int[]{10,15,20},
                new int[]{1,100,1,1,1,100,1,1,100,1}
                        );
    }
}