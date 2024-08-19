/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.graph.GraphDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/1
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.graph;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 类描述： GraphDemo
 **/
public class GraphDemo {

    @ParameterizedTest
    @MethodSource(value = "findJudgeSource")
    public void testFindJudge(int n, int[][] trust){
        System.out.println(findJudge(n, trust));
    }

    public int findJudge(int n, int[][] trust) {
        int count = trust.length;
        if(count<n-1) return -1;
        int[][] id=new int[n+1][2];

        for (int[] ints : trust) {
            int a=ints[0],b=ints[1];
            id[a][0]+=1;
            id[b][1]+=1;
        }

        for (int i = 1; i < n+1; i++) {
            int a=id[i][0],b=id[i][1];
            if(b==n-1 && a==0) return i;
        }

        return -1;
    }

    public static Stream<Arguments> findJudgeSource(){
        return Stream.of(
                Arguments.of(2,new int[][]{{1,2}}),
                Arguments.of(3,new int[][]{{1,3},{2,3}}),
                Arguments.of(3,new int[][]{{1,3},{2,3},{3,1}})
                        );
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3})
    public void clmb(int n){
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i < n; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[n-1]);

    }

    public void testSnakesAndLadders(int[][] board) {
        System.out.println(board);
    }


    public int snakesAndLadders(int[][] board) {
        return 0;
    }
}