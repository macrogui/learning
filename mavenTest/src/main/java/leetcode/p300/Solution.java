package leetcode.p300;

public class Solution {
    private int[] memo;

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        int max = memo[0];
        for (int num : memo) {
            if (num>max)
                max = num;
        }
        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
