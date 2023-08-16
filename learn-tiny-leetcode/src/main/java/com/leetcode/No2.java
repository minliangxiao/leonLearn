package com.leetcode;

/**
 * [2.两数相加]
 *  中等题
 * @author : [${Harlan.Hwang}]
 * @version : [v1.0]
 * @createTime : [2023/8/16 14:03]
 * 解题思路  只需要记住公式 新连表 sum =  addX+addY+up 连表值 val =sum%10  下一个进位为up = sum/10
 *
 *  
 */
public class No2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode tem = res;
        ListNode p = l1;
        ListNode q = l2;
        int up = 0 ;
        while (p !=null|| q != null){
             int addx = p == null?0: p.val;
             int addy = q == null?0: q.val;
             int sum = addx+addy+up;
             tem.next = new ListNode(sum % 10);
             up = sum / 10;
             if (p != null) p= p.next;
             if (q != null) q= q.next;
             tem =  tem.next;
        }
        if (up>0){
            tem.next= new ListNode(up);
        }

      return res.next;
    }

 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}


