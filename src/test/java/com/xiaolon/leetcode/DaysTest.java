package com.xiaolon.leetcode;


import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

/*
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.DaysTest
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/21
 *
 */
class DaysTest {

    @ParameterizedTest
    @MethodSource(value = "canMakeSquareProvider")
    public void canMakeSquare(char[][] grid) {
        Days days = new Days();
        System.out.println(days.canMakeSquare(grid));

    }
    public static Stream<char[][]> canMakeSquareProvider() {
        return Stream.of(
                new char[][]{{'B','W','B'},{'B','W','W'},{'B','W','B'}},
                new char[][]{{'B','W','B'},{'B','W','W'},{'B','W','B'}}
                        );
    }

    @ParameterizedTest
    @MethodSource(value = "maxStrengthProvider")
    void maxStrength(int[] nums) {
        Days days = new Days();
        System.out.println(days.maxStrength(nums));
    }
    public static Stream<int[]> maxStrengthProvider() {
        return Stream.of(
                new int[]{3,-1,-5,2,5,-9},
                new int[]{-4,-5,-4}
        );
    }

    @ParameterizedTest
    @ValueSource(strings = "abcde")
    void longestContinuousSubstring(String s) {
        Days days = new Days();
        System.out.println(days.longestContinuousSubstring(s));
    }

    @ParameterizedTest
    @MethodSource(value = "edgeScoreProvider")
    void edgeScore(int[] deges) {
        Days days = new Days();
        System.out.println(days.edgeScore(deges));
    }

    public static Stream<int[]> edgeScoreProvider() {
        return Stream.of(
                new int[]{1,0,0,0,0,7,7,5},
                new int[]{2,0,0,2}
        );
    }
}