/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.tree.TreeProb
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/24
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.tree;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述： TreeProb
 **/
public class TreeProb {


    public static void main(String[] args) {

    }

    public static void dfs(TreeNode root, Deque list){
        if(root==null) return;

        dfs(root.left,list);
        dfs(root.right,list);
        list.offerLast(root);
    }


    public static void prob3(TreeNode root){

    }

    public static void dfs3(){

    }

    /**
     * 计算根到叶子节点构成数字之和
     * @param root
     */
    public static void prob1(TreeNode root){
        // 深度遍历
        dfsProb1(root, 0);

    }
    public static int dfsProb1(TreeNode root, int sum){
        if (root ==null)return 0;

        sum = 10*sum + root.val;
        if(root.left==null && root.right==null) return sum;

        return dfsProb1(root.left, sum)+ dfsProb1(root.right, sum);
    }


    /**
     * 计算路径和等于给定值的路径数
     * @param root
     */
    public static void prob2(TreeNode root){
        // 路径->深度遍历

    }

    public static int dfsProb2(TreeNode root, int sum, int target){
        // 分别计算以当前节点为起点，计算路径和。
        if(root == null) return 0;
        // 计算到当前节点路径和
        sum += root.val;

        // 计算以当前节点为起点的路劲和
        int count = dfsProb1(root.left, root.val) + dfsProb1(root.right, root.val);
        return sum==target?1+count:count;

    }
}