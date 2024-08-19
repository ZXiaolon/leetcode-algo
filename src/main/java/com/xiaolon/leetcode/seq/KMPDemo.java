/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.seq.KMPDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/1
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.seq;

import java.util.Arrays;

/**
 * 类描述： KMPDemo
 **/
public class KMPDemo {
    public static void main(String[] args) {
        String text = "BBC ABCDAB CDABABCDABCDABDE";
        String pattern = "ABCDABD";

        System.out.println("Matched Locatioin :"+kmp(text, pattern));
    }

    /**
     * kmp模式匹配算法
     * @param text
     * @param pattern
     * @return
     */
    public static int kmp(String text, String pattern){
        int m=text.length();
        int n=pattern.length();
        int[] next=getNext(pattern);
        int i=0,j=0;
        while(i<m && j<n){
            if(j==-1 || text.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
            }else{
                j=next[j];
            }
            if(j==n) return i-j;
        }

        return -1;
    }

    /**
     * 描述：根据pattern求解next数组
     * @param pattern
     * @return
     */
    public static int[] getNext(String pattern){
        int n=pattern.length();
        int[] next=new int[n];
        next[0]=-1;
        int k=-1;
        int j=0;
        while(j<n-1){
            if(k==-1 || pattern.charAt(k)==pattern.charAt(j)){
                k++;
                j++;
                next[j]=k;
            }else {
                k=next[k];
            }
        }
        System.out.println("next: " + Arrays.toString(next));
        return next;
    }
}