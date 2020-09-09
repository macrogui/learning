package leetcode.p459;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        loop: for (int i = N / 2; i >= 1; i--) {
            if (N % i != 0)
                continue;
            for (int j = 1; j < N / i; j++) {
                if (!s.substring((j-1)*i, j*i).equals(s.substring(j*i, (j+1)*i))){
                    continue loop;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("abcabcabc"));
    }
}
