package leetcode.p213;

import java.util.Arrays;

public class Solution {
    private int[] memo;

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length==1)
            return nums[0];
        memo = new int[nums.length+1];
        return Math.max(maxPrice(Arrays.stream(nums).limit(nums.length-1).toArray()),maxPrice(Arrays.stream(nums).skip(1).limit(nums.length-1).toArray()));
    }

    private int maxPrice(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length==1)
            return nums[0];
        int length = nums.length;
        memo[0] = 0;
        memo[1] = nums[0];
        memo[2] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            memo[i+1] = Math.max(memo[i-1]+nums[i],memo[i]);
        }
        return memo[length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{0,0}));
    }
}
