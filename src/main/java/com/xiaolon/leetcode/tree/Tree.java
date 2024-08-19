/*
 *   Copyright © 2018 重庆市信息通信咨询设计院有限公司版权所有.
 *
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.structres.Tree
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/16
 *
 *   版权描述：此软件未经重庆市信息通信咨询设计院有限公司许可，严禁发布、传播、使用.
 *   公司地址：重庆市九龙坡区科园四路257号,400041.
 *
 */
package com.xiaolon.leetcode.tree;

import lombok.val;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 类描述： Tree
 **/
public class Tree {



    public static void main(String[] args) {

        //int[] nodes = new int[]{1,2,3,4,5,6,7};

        Integer[] nodes =new Integer[]{1,2,3,4,5,null,7};

        TreeNode root = buildTree(nodes);

        System.out.println("\n========中序遍历（递归）=====");
        inOrder(root);
        System.out.println("\n========中序遍历（迭代-栈）=====");
        inOrder1(root);

        System.out.println("\n\n========前序遍历（递归）=====");
        preOrder(root);
        System.out.println("\n========前序遍历（迭代-栈）=====");
        preOrder1(root);

        System.out.println("\n\n========后续遍历（递归）=====");
        postOrder(root);
        System.out.println("\n========后续遍历（迭代-栈）=====");
        postOrder1(root);

        System.out.println("\n\n========层次遍历（迭代-队列）=====");
        layerOrder(root);


    }

    /**
     * 前序+中序=>二叉树
     * @return
     */
    public static TreeNode getTree1(int[] preOrder, int[] inOrder){
        int n=preOrder.length;
        if(n==0) return null;
        // 通过前序确定根，并通过节点再中序数组中与父节点的相对位置来确定要插入的位置；
        // 将中序遍历用map保存
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inOrder[i], i);
        }

        // 中序遍历插入
        TreeNode root = new TreeNode(preOrder[0]);
        TreeNode cur=root;
        for (int i = 1; i < n; i++) {
            TreeNode node = new TreeNode(preOrder[i]);
            int loc = map.get(preOrder[i]);

        }


        return null;
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
     * 构建树
     * @param nodes
     * @return
     */
    public static TreeNode buildTree(int[] nodes){
        if(nodes.length <1 ) return null;
        int n = nodes.length;
        int total = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(nodes[0]);
        total++;
        queue.offer(root);

        while(total<n){
            TreeNode node = queue.poll();

            node.left = new TreeNode(nodes[total++]);
            queue.offer(node.left);

            if(total<n){
                node.right = new TreeNode(nodes[total++]);
                queue.offer(node.right);
            }
        }
        return root;
    }

    /**
     * 中序遍历递归实现
     * @param root
     */
    public static void inOrder(TreeNode root){
        if(root == null) return ;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }

    /**
     * 中序遍历-栈实现
     * @param root
     */
    public static void inOrder1(TreeNode root){
        // 一直往左走，直到为空
        //弹出节点，访问，再添加右节点到栈

        if(root==null)return;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        stack.push(root);
        while (!stack.isEmpty()){
            while (cur.left!=null){
                stack.push(cur.left);
                cur=cur.left;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            if(cur.right!=null) {
                stack.push(cur.right);
                cur=cur.right;
            }
        }
    }

    /**
     * 前序遍历-递归
     * @param root
     */
    public static void preOrder(TreeNode root){
        if(root==null)return;

        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    /**
     * 前序遍历-迭代
     * @param root
     */
    public static void preOrder1(TreeNode root){
        if(root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
    }

    /**
     * 递归实现树的后续遍历
     * @param root
     */
    public static void postOrder(TreeNode root){
        if (root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }

    /**
     * 迭代实现树的后续遍历
     * @param root
     */
    public static void postOrder1(TreeNode root){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode prev = null;

        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            cur = stack.peek();
            if(cur.right!=null && cur.right!=prev){
                cur=cur.right;
            }else{
                stack.pop();
                System.out.print(cur.val + " ");
                prev = cur;
                cur =null;
            }
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public static void layerOrder(TreeNode root){
        // 改进，返回一个列表，从列表中打印树结构
        if(root == null) return;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            for(int i=0;i<queue.size();i++){
                TreeNode node = queue.poll();
                System.out.print(node.val+" ");
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
    }



}
