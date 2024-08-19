package com.xiaolon.leetcode.linear;

import com.xiaolon.leetcode.linear.definition.ListNode;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.linear.LinearDemoTest
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/12
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */class LinearDemoTest {

     @Test
     public void testA(){
         ListNode head = ListNode.getInstance(new int[]{1,2,3,4,5});
         head.next.show();
     }


     @ParameterizedTest
     @MethodSource(value = "rotateRightSource")
    void testRotateRight(ListNode head, int k) {
         ListNode ret = rotateRight(head, k);
         ret.show();
    }

    public ListNode rotateRight(ListNode head, int k) {
         // 找到正数第k个以及倒数第k个
        if(head==null)return null;
        if(k==0) return head;

        List<ListNode> list=new ArrayList<>();
        ListNode cur=head;
        while (cur!=null){
            list.add(cur);
            cur=cur.next;
        }

        int n=list.size();
        k=k%n;

        cur = list.get(n - k - 1);
        ListNode last = list.get(n - 1);
        ListNode first = list.get(0);
        last.next=first;
        ListNode newHead=cur.next;
        cur.next=null;
        return newHead;
    }


    public static Stream<Arguments> rotateRightSource(){
        return Stream.of(
                Arguments.of(ListNode.getInstance(new int[]{1,2,3,4,5}), 2),
                Arguments.of(ListNode.getInstance(new int[]{0,1,2}), 4)
                        );
    }
}