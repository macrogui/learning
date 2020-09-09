package leetcode.p494;

public class Solution {
    private int bingo = 0;
    public int findTargetSumWays(int[] nums, int S) {
        helper(nums, nums.length-1, S);
        return bingo;
    }

    private void helper(int[] nums, int index, int s) {
        if (index==0){
            if (s == nums[0]||s == -nums[0]){
                bingo++;
                //+0,-0都算
                if (nums[0]==0) {
                    bingo++;
                }
            }
            return;
        }
        helper(nums, index-1, s-nums[index]);
        helper(nums, index-1, s+nums[index]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1,1,1,1}, 3));
    }
}
