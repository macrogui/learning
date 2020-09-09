package leetcode.p392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] chars = t.toCharArray();
        int si = 0;
        for (int i = 0; i < chars.length && si < s.length(); i++) {
            if (chars[i] == s.charAt(si)) {
                si++;
            }
        }
        return si == s.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abc", "ahbgdc"));
    }
}
