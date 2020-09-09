package leetcode.p70;

public class Solution {

    public int climbStairs(int n) {
        int[] ints = new int[n+2];
        return inner(ints, n);
    }

    private int inner(int[] ints, int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (ints[n]!=0){
            return ints[n];
        }
        int res = inner(ints, n - 1) + inner(ints, n - 2);
        ints[n] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(45));
    }
}
