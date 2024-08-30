/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.tree.demo.BTDemo1
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/2
 *
 */
package com.xiaolon.leetcode.tree.demo;

import com.xiaolon.leetcode.tree.TreeNode;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

/**
 * 类描述： BTDemo1
 **/
public class BTDemo1 {


    public static boolean containsNearbyAlmostDuplicate(int[] nums,
                                                        int k, int t){
        TreeSet<Long> set=new TreeSet<>();
        for(int i=0;i< nums.length;i++){
            Long lower=set.floor((long)nums[i]);
            if(lower!=null && lower>=(long)nums[i]-t){
                return true;
            }
            Long upper=set.ceiling((long)nums[i]);
            if(upper!=null && upper<=(long)nums[i]+t){
                return true;
            }
            set.add((long)nums[i]);
            if(i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    /**
     * 自定义日程安排
     */
    class MyCalendar{
        private TreeMap<Integer, Integer> events;

        public MyCalendar(){
            events=new TreeMap<>();
        }

        public boolean book(int start, int end){
            Map.Entry<Integer, Integer> event = events.floorEntry(start);
            if(event!=null && event.getValue()>start){
                return false;
            }
            event = events.ceilingEntry(start);
            if(event!=null && event.getKey()<end){
                return false;
            }
            events.put(start,end);
            return true;
        }
    }


    public int getMinimumDifference(TreeNode root) {
        // 计算左右2个数字的差值
        List<Integer> list=new ArrayList<>();
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode cur=root;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur=stack.pop();
            list.add(cur.val);
            cur=cur.right;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(list.get(i)-list.get(i-1));
            if(diff<min)min=diff;
        }
        return min;
    }





    @ParameterizedTest
    @MethodSource("getRoot")
    public void testIsValidBST(TreeNode root){
        System.out.println(isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }

    public static Stream<TreeNode> getRoot(){
        return Stream.of(
                new TreeNode(0)
                        );
    }






}