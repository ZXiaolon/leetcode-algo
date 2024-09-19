/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.LeetCodeDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/16
 */
package com.xiaolon.leetcode;

import java.util.*;

/**
 * 类描述： LeetCodeDemo
 **/
public class LeetCodeDemo {

    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {



    }
    public boolean findTarget(TreeNode root, int k) {
        dfs(root);
        return false;
    }

    public void dfs(TreeNode root){
        if(root==null)return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}