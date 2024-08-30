/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.linear.definition.ListNode
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/7/12
 *
 */
package com.xiaolon.leetcode.linear.definition;

/**
 * 类描述： ListNode
 **/
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


    /**
     * 根据数组生成ListNode
     * @param arr
     * @return
     */
    public static ListNode getInstance(int[] arr){
        ListNode head=new ListNode(0);
        ListNode cur=head;
        for (int i : arr) {
            cur.next=new ListNode(i);
            cur=cur.next;
        }
        return head.next;
    }

    /**
     * 遍历当前链表
     */
    public void show(){
        ListNode cur=this;
        while(cur!=null){
            System.out.print(cur.val +" ");
            cur=cur.next;
        }
    }
}