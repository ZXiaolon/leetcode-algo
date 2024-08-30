/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.structres.Morris
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/20
 *
 */
package com.xiaolon.leetcode.tree;

/**
 * 类描述： Morris
 **/
public class Morris {

    public static void main(String[] args) {

    }


    /**
     * Morris前序遍历：树->链表（）
     * @param root
     */
    public static void preOrderMorris(TreeNode root){
        if(root==null)return;
        TreeNode cur=root;
        while (cur!=null){
            // 查看左子树
            if(cur.left==null){
                // 左子树为空，访问右子树
                cur=cur.right;
            }else{
                //找到左子节点的最有节点
                TreeNode left=cur.left;
                TreeNode mostRight = left;
                // 不断往右走
                while (mostRight.right!=null && mostRight.right!=cur){
                    mostRight=mostRight.right;
                }

                //第一次访问
                if(mostRight.right==null){
                    System.out.println(cur.val + " ");
                    mostRight.right=cur;
                    cur=cur.left;
                }else {
                    //第二次访问，还原
                    mostRight.right=null;
                    cur=cur.right;
                }
            }
        }

    }

    /**
     * Morris中序遍历
     * @param root
     */
    public static void inOrderMorris(TreeNode root){
        if(root==null) return;
        TreeNode cur=root;

        while (cur!=null){
            if(cur.left==null){
                // 当前节点没有左子树
                System.out.println(cur.val+" ");
            }else{
                TreeNode left=cur.left;
                TreeNode mostRight=left;
                while (mostRight.right!=null && mostRight.right!=cur){
                    mostRight=mostRight.right;
                }

                if (mostRight.right == null) {
                    // 第一次访问
                    mostRight.right=cur;
                }else{
                    // 第二次访问，恢复即可
                    System.out.println(cur.val+" ");
                    mostRight.right=null;
                    cur=cur.right;
                }

            }
        }
    }


    /**
     * Morris后续遍历
     * @param root
     */
    public static void postOrderMorris(TreeNode root){
        if(root==null) return;
        TreeNode cur=root;

        while (cur!=null){
            if(cur.left==null){
                cur=cur.right;
            }else{
                TreeNode left=cur.left;
                TreeNode mostRight=left;
                while (mostRight.right!=null && mostRight.right!=cur){
                    mostRight=mostRight.right;
                }

                // 第一次访问
                if(mostRight.right==null){
                    mostRight.right=cur;
                    cur=cur.left;
                }else {
                    // 逆序打印当前左子节点
                    mostRight.right=null;
                    printReverse(cur.left);
                    cur=cur.right;
                }
            }
        }

        // 最后需要逆序打印根节点右侧节点
        printReverse(root);
    }

    /**
     * 递归逆序打印列表
     * @param node
     */
    public static void printReverse(TreeNode node){
        if(node ==null)return;
        printReverse(node.right);
        System.out.println(node.val +" ");
    }


}