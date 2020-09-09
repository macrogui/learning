package leetcode.p416;

import java.util.Arrays;

public class Solution {
    private Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        if (sum%2!=0)
            return false;
        int target = sum / 2;
        memo = new Boolean[nums.length][target+1];
        return helper(nums, nums.length-1, target);
    }

    private boolean helper(int[] nums, int index, int target) {
        if (target == 0){
            return true;
        }
        if (index < 0 || target < 0){
            return false;
        }
        if (memo[index][target] == null) {
            memo[index][target] = helper(nums, index - 1, target) || helper(nums, index - 1, target - nums[index]);
        }
        return memo[index][target];
    }
}
