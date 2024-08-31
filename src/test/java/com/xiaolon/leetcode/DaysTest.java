package com.xiaolon.leetcode;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.DaysTest
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/21
 *
 */class DaysTest {

    @Test
    void getPrice() {
        System.out.println(""+Math.abs('B'-'W'));
    }

    @Test
    void findMaximumNumber() {

    }

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
}