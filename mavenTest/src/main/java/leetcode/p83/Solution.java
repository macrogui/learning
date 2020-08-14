package leetcode.p83;


class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null && head.next.val == head.val) {
            head = head.next;
        }
        head.next = deleteDuplicates(head.next);

        return head;
    }
}