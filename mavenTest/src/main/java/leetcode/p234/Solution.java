package leetcode.p234;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {

        LinkedList<ListNode> list = new LinkedList<>();

        ListNode p = head;
        while(p!=null){
            list.add(p);
            p = p.next;
        }
        while(list.size()>1){
            int f = list.removeFirst().val;
            int l = list.removeLast().val;
            if(f!=l)
                return false;
        }
        return true;
    }
}