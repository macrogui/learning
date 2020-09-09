package leetcode.p279;

public class Solution {
    private int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];
        memo[0] = 0;
        for (int i = 1; i <= n; i++) {
            memo[i] = Integer.MAX_VALUE-1;
            for (int j = 1; j * j <= i; j++) {
                memo[i] = Math.min(memo[i], memo[i - j*j] + 1);
            }
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(13));
    }
}
