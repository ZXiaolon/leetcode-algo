/*
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.hot100.TreeNode
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/29
 *
 */
package com.xiaolon.leetcode.hot100;

/**
 * 类描述： TreeNode
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
