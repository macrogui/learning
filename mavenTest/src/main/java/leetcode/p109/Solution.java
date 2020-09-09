package leetcode.p109;

import javax.xml.soap.Node;
import java.util.ArrayList;

class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        ListNode cur = head;
        if (head == null) {
            return null;
        }
        ArrayList<ListNode> arr = new ArrayList<>();
        arr.add(cur);
        while (cur.next != null) {
            cur = cur.next;
            arr.add(cur);
        }
        int length = arr.size();
        int l = 0;
        int r = length;
        TreeNode root = getNode(arr, l, r);
        return root;
    }

    private TreeNode getNode(ArrayList<ListNode> arr, int l, int r) {
        if (l == r) {
            return null;
        }
        return new TreeNode(arr.get((l + r) / 2).val, getNode(arr, l, (l + r) / 2), getNode(arr, (l + r) / 2 + 1, r));
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        TreeNode treeNode = new Solution().sortedListToBST(l1);
        System.out.println(treeNode);
    }
}