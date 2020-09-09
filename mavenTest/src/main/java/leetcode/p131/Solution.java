package leetcode.p131;

import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            List<List<String>> ret = new ArrayList<>();
            ret.add(new LinkedList<>());
            return ret;
        }

        List<List<String>> ret = new LinkedList<>();
        for (int i = 1; i < s.length()+1; i++) {
            if (isPaartition(s.substring(0, i))) {
                for (List<String> list : partition(s.substring(i))) {
                    list.add(0, s.substring(0, i));
                    ret.add(list);
                }
            }
        }
        return ret;
    }

    private boolean isPaartition(String temp) {
        StringBuilder sb = new StringBuilder(temp);
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("abcba"));
    }
}
