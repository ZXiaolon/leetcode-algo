/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.tree.TreeNode
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/21
 */
package com.xiaolon.leetcode.tree;

/**
 * 定义树结构
 * 类描述： TreeNode
 **/

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }




}
