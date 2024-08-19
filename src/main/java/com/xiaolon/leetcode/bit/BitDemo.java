/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.bit.BitDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/16
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.bit;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.beans.Transient;

/**
 * 类描述： BitDemo
 **/
public class BitDemo {



    @Test
    public void testA(){

        System.out.println(0.1f * 0.1f);

    }


    @ParameterizedTest
    @ValueSource(ints = {-3})
    public void testReverseBits(int n){
        reverseBits(n);
    }

    public int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        System.out.println(binaryString);
        int i = Integer.reverseBytes(n);
        System.out.println("i: "+ i);
        return i;

    }
}