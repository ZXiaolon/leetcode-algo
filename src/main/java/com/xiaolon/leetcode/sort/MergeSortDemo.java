/*
 *   项目名称：leetcode
 *   文件名称：com.xiaolon.leetcode.sort.MergeSortDemo
 *
 *   创建人：  ZHOU XIAO LONG
 *   创建日期：2024/6/16
 *
 */
package com.xiaolon.leetcode.sort;

import cn.hutool.http.Header;
import lombok.val;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 类描述： MergeSortDemo
 **/
public class MergeSortDemo {
    public static void main(String[] args) {


        System.out.println("========排序前=========");
        Integer[] arr = new Integer[]{3,5,1,4,2,6,9,8};
        Node head = buildNode(arr);
        iterNode(head);
        System.out.println("========序链表排序=========");
        mergeSort(head);
        iterNode(head);


        //======================合并排序链表=========================
        Node list1 = buildNode(new Integer[]{1, 4, 7});
        Node list2 = buildNode(new Integer[]{2, 5, 8});
        Node list3 = buildNode(new Integer[]{3, 6, 9});
        Node[] lists = new Node[]{list1, list2, list3};
        System.out.println("========k个有序链表排序=========");
        Node list = mergeList(lists);
        iterNode(list);




    }


    /**
     * 利用最小堆实现k个有序链表排序
     * @param lists
     * @return
     */
    public static Node mergeList(Node[] lists){
        Node dummy = new Node(0);
        Node curr = dummy;

        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((ele1, ele2)-> ele1.data-ele2.data);
        for (Node list: lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        //
        while (!minHeap.isEmpty()){
            Node least = minHeap.poll();
            curr.next = least;
            curr = least;

            if(least.next!=null){
                minHeap.offer(least.next);
            }
        }

        return dummy.next;
    }

    /**
     * 实现对链表的归并排序
     * @param head
     * @return
     */
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node list1=head;
        Node list2=splitList(head);

        list1 = mergeSort(list1);
        list2 = mergeSort(list2);

        return mergeList(list1, list2);
    }

    /**
     * 归并两个链表，过程进行排序
     * @param list1
     * @param list2
     * @return
     * @param 
     */
    public static Node mergeList(Node list1, Node list2){
        Node dummy = new Node(0);
        Node curr=dummy;
        
        while(list1!=null && list2!=null){
            if(list1.data<list2.data){
                curr.next=list1;
                list1=list1.next;
            }else{
                curr.next=list2;
                list2=list2.next;
            }
            curr = curr.next;
        }

        curr.next = list1==null?list2:list1;
        return dummy.next;
    }

    /**
     * 利用快慢指针实现对链表的拆分
     * @param head
     * @return
     * @param 
     */
    public static  Node splitList(Node head){
        Node slow=head;
        Node fast=head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node second = slow.next;
        slow.next=null;
        return second;
    }
    
    

    public static void iterNode(Node head){
        Node curr=head;
        while (curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static  Node buildNode(Integer[] arr){
        Node head = null;
        Node curr=null;
        for(Integer ele: arr){
            if(head==null){
                head= new Node(ele);
                curr=head;
            }else{
                curr.next = new Node(ele);
                curr=curr.next;
            }
        }
        return head;
    }

}

class Node{
    Integer data;
    Node next;

    Node(){
        this.next=null;
    }
    Node(Integer data){
        this.data=data;
        this.next=null;
    }

}