package leetcode.p17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ret = new ArrayList<>();
    private String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return ret;
        helper(digits, 0, "");
        return ret;
    }

    private void helper(String digits, int index, String s) {
        if (index == digits.length()) {
            ret.add(s);
            return;
        }
        String cur = dict[digits.charAt(index) - '0'];
        char[] chars = cur.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            helper(digits,index+1, s + String.valueOf(chars[i]));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
