/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.tree.TreeTransfer
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/21
 */
package com.xiaolon.leetcode.tree;

import lombok.val;

/**
 * 类描述： TreeTransfer
 * 序列化与反序列化
 * 以及
 * 树结构和其他结构的转换
 **/
public class TreeTransfer {
    public static void main(String[] args) {
        //int[] nodes = new int[]{1,2,3,4,5,6,7};

        Integer[] nodes =new Integer[]{1,2,3,4,5,6};

        TreeNode root = buildTree(nodes);

        System.out.println("\n=========序列化结构==============");
        String serialTree = serialize(root);
        System.out.println(serialTree);

        System.out.println("\n=========反序列化结构==============");
    }

    /**
     * 数组->二叉树
     * 遍历数组中所有非叶子节点
     *
     * @param nodes
     * @return
     */
    public static TreeNode buildTree(Integer[] nodes){
        if(nodes.length==0)return null;
        int n = nodes.length;
        TreeNode[] nodeList = new TreeNode[n];

        // 满二叉树的组后一个非叶子节点多少
        for (int i = 0; i < n; i++) {
            if(nodes[i]!=null){
                nodeList[i] = new TreeNode(nodes[i]);
            }
        }

        for (int i = 0; i < n/2; i++) {
            if(nodes[i]!=null){
                int left = 2*i+1;
                int right = 2*i+2;
                if(left<n) nodeList[i].left = nodeList[left];
                if(right<n) nodeList[i].right = nodeList[right];
            }

        }

        return nodeList[0];
    }



    /**
     * 序列化：树->字符串(前序)
     * @param root
     * @return
     */
    public static String serialize(TreeNode root){
        if(root==null) {
            return "#";
        }
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return String.valueOf(root.val)+","+leftStr+","+rightStr;
    }

    /**
     * 反序列化：字符串->树
     * @param val
     * @return
     */
    public static TreeNode deserialize(String val){
        String[] nodeStrs = val.split(",");
        int[] i = {0};
        return dfs(nodeStrs, i);

    }
    public static TreeNode dfs(String[] strs, int[] i){
        String str = strs[i[0]];
        i[0]++;
        if(str.equals("#")) return null;

        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(strs, i);
        node.right =dfs(strs, i);
        return node;
    }




}

