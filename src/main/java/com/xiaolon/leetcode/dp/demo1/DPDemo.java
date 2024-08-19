/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.dp.demo1.DPDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/16
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.dp.demo1;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 类描述： DPDemo
 **/


public class DPDemo {

    @ParameterizedTest
    @MethodSource(value = "lengthOfLastWordSource")
    public void testLengthOfLastWord(String s){
        System.out.println("最后一个单词的长度");
        System.out.println("s: "+s);
        System.out.println(lengthOfLastWord(s));
    }
    public int lengthOfLastWord(String s) {
        String[] strArr = s.split(" ");
        return strArr[strArr.length-1].length();
    }

    public static Stream<String> lengthOfLastWordSource(){
        return Stream.of(
                "Hello World",
                "   fly me   to   the moon  ",
                "luffy is still joyboy"
                        );
    }


    /**
     * 打家劫舍，leetcode：198
     * @param nums
     * @return
     */
    @ParameterizedTest
    @MethodSource(value = "robDataSource")
    public void testRob(int[] nums){
        System.out.println("leetcode: 198");
        System.out.println(rob(nums));
    }

    public int rob(int[] nums){
        int n=nums.length;
        int[] value= new int[n];
        for (int i = 0; i < n; i++) {
            if(i==0) value[i]=nums[i];
            else if(i==1) value[i] = Math.max(nums[0], nums[1]);
            else{
                value[i] = Math.max(value[i-2]+nums[i], value[i-1]);
            }
        }
        return value[n-1];
    }

    public static Stream<int[]> robDataSource(){
        return Stream.of(
                new int[]{1,2,3,1},
                new int[]{2,7,9,3,1}
                        );
    }
}