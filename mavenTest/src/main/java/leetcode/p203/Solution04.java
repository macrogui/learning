package leetcode.p203;

/**
 * 应用递归
 */
public class Solution04 {
    public ListNode removeElements(ListNode head, int val) {
        //递归的终止条件
        if (head == null){
            return null;
        }
        ListNode res = removeElements(head.next, val);
        if (head.val == val){
            return res;
        } else {
            head.next = res;
            return head;
        }
    }
}
