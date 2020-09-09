package leetcode.p93;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> ret = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        helper(s, 4, "");
        return ret;
    }

    private void helper(String s, int need, String s1) {
        if (s.length()<need) return;
        if (need == 0){
            if (s.equals(""))
                ret.add(s1.substring(0,s1.length()-1));
                return;
        }
        if (s.charAt(0)!='0') {
            if (s.length()>=2&&isValid(s.substring(0, 2)))
                helper(s.substring(2), need-1, s1+s.substring(0, 2)+".");
            if (s.length()>=3&&isValid(s.substring(0, 3)))
                helper(s.substring(3), need-1, s1+s.substring(0, 3)+".");
        }
        helper(s.substring(1), need-1, s1+s.substring(0, 1)+".");
    }

    private boolean isValid(String s) {
        return Integer.parseInt(s)>=0&&Integer.parseInt(s)<=255;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("101023"));
    }
}