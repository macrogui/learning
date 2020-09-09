package leetcode.p343;

public class Solution02 {
    private int[] memo;
    public int integerBreak(int n) {
        memo = new int[n+1];
        return getMax(n);
    }

    private int getMax(int n) {
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i-1; j++) {
                memo[i] = Math.max(Math.max(j*memo[i-j], (i-j)*j), memo[i]);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution02().integerBreak(10));
    }
}
