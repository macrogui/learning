package leetcode.p71;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for (String s : split) {
            if (s.length() != 0 && !s.equals(".")) {
                System.out.println(s);
                if (s.equals("..")) {
                    stack.pollFirst();
                    continue;
                }
                stack.push(s);
            }
        }
        StringBuilder res = new StringBuilder("/");
        while (!(stack.isEmpty() && res.length() > 1)) {
            String s = stack.pollLast();
            res.append(s == null ? "" : s).append("/");
        }
        return res.substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/../"));
    }
}
