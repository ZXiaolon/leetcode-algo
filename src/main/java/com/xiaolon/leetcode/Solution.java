/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.Solution
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/2
 */
package com.xiaolon.leetcode;

import com.xiaolon.leetcode.tree.TreeNode;
import com.xiaolon.leetcode.tree.TreeUtils;
import org.junit.jupiter.api.Test;


import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.Stream;


/**
 * 类描述： Solution
 **/


public class Solution {



    public static void main(String[] args) {
        Integer[] nodes=new Integer[]{3,9,20,null,null,15,7};
        TreeNode root = TreeUtils.getTreeFromLayer(nodes);
        List<List<Integer>> ret = levelOrderBottom(root);

        for (List<Integer> ele:ret){
            ele.forEach(e-> System.out.print(e+","));
            System.out.println();
        }
    }



    public int[][] modifiedMatrix(int[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[] maxCol=new int[n];
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int ele=matrix[i][j];
                if(ele==-1) list.add(new int[]{i,j});
                if(ele>maxCol[j])maxCol[j]=ele;
            }
        }
        for(int[] ele: list){
            int row=ele[0];
            int col=ele[1];
            matrix[row][col]=maxCol[col];
        }
        return matrix;
    }


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret=new ArrayList<>();
        Deque<TreeNode> queue=new LinkedList<>();

        if(root==null){
            return ret;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int size= queue.size();
            List<Integer> layer=new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node=queue.poll();
                layer.add(node.val);
                if(node.left!=null)queue.push(node.left);
                if(node.right!=null)queue.push(node.right);
            }
            ret.add(0,layer);
        }
        return ret;
    }


}