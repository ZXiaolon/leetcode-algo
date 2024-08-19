/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.seq.SeqDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/15
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.seq;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 类描述： SeqDemo
 **/
public class SeqDemo {


    @ParameterizedTest
    @MethodSource(value = "")
    public void testAccountsMerge(List<List<String>> accounts){
        accountsMerge(accounts);
    }


    @Test
    public void testA(){
        List<List<String>> list1=Arrays.asList(
                Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"),
                Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co")
                                     );


    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {


        return null;
    }


    public static Stream<List<List<String>>> accountsMergeSource(){
        return Stream.of();
    }



}