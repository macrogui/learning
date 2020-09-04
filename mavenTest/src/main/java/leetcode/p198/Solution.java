package leetcode.p198;

public class Solution {
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length+1];
        return maxPrice(nums);
    }

    private int maxPrice(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        if (length==1)
            return nums[0];
        memo[0] = 0;
        memo[1] = nums[0];
        memo[2] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            memo[i+1] = Math.max(memo[i-1]+nums[i],memo[i]);
        }
        return memo[length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{}));
    }
}
