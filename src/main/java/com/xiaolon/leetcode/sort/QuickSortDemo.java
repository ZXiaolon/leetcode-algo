/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.sort.QuickSortDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/16
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 类描述： QuickSortDemo
 **/
public class QuickSortDemo {


    public static void main(String[] args) {
        int[] arr=new int[]{6,5,4,3,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    public static void quickSort(int[] arr,int left, int right){
        if(right>left){
            int pivot=partition(arr, left, right);
            quickSort(arr, left, pivot-1);
            quickSort(arr, pivot+1, right);
        }
    }

    /**
     * 分区
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int partition(int[] arr, int left, int right){
        int random=new Random().nextInt(right-left+1)+left;
        swap(arr,random, right);

        int small=left-1;
        for (int i = left; i < right; i++) {
            if(arr[i]<arr[right]){
                small++;
                swap(arr, i, small);
            }
        }
        small++;
        swap(arr, small, right);
        return small;
    }

    /**
     * 交换数组中idx1与idx2
     * @param arr
     * @param idx1
     * @param idx2
     */
    public static void swap(int[] arr, int idx1, int idx2){
        if(idx1!=idx2){
            int temp=arr[idx1];
            arr[idx1]=arr[idx2];
            arr[idx2]=temp;
        }
    }


}