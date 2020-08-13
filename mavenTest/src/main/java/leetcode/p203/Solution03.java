package leetcode.p203;

/**
 * 使用虚拟头节点
 */
public class Solution03 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else
                prev = prev.next;
        }

        return dummyHead.next;
    }
}
