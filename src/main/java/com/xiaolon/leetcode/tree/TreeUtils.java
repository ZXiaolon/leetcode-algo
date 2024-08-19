/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode-algo
 *   文件名称：com.xiaolon.leetcode.tree.TreeUtils
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/8/19
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.tree;

/**
 * 类描述： TreeUtils
 **/
public class TreeUtils {
    /**
     * 按层次遍历构建二叉树
     * @return
     */
    public static TreeNode getTreeFromLayer(Integer[] nodes){
        int n=nodes.length;
        if(n==0) return null;
        TreeNode[] treeNodes=new TreeNode[n];
        for (int i = 0; i < n; i++) {
            treeNodes[i]=nodes[i]==null?null:new TreeNode(nodes[i]);
        }
        for (int i = 0; i < n/2-1; i++) {
            if(treeNodes[i]!=null){
                treeNodes[i].left=treeNodes[2*i+1];
                treeNodes[i].right=treeNodes[2*i+2];
            }
        }
        return treeNodes[0];
    }
}