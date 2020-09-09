package leetcode.p343;

public class Solution {
    private Integer[] memo;
    public int integerBreak(int n) {
        memo = new Integer[n];
        return getMax(n);
    }

    private int getMax(int n) {
        if (n == 1){
            return 1;
        }
        if (memo[n-1]!=null)
            return memo[n-1];
        int max = -1;
        for (int i = 1; i < n; i++) {
            max =  Math.max(Math.max(max, getMax(n-i)*i),(n-i)*i);
        }
        memo[n-1] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMax(30));
    }
}
