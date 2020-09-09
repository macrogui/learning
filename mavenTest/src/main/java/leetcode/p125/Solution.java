package leetcode.p125;

public class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c>=97&&c<122 || c>=48&&c<58){
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("0P"));
    }
}
