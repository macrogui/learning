package leetcode.p416;

import java.util.Arrays;

/**
 * 使用动态规划尝试解决
 * 通过二维数组记录取前n个数字时相加（随意取元素），是否能得到m。
 */
public class Solution02 {
    private Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        if (sum%2!=0)
            return false;
        int target = sum / 2;
        int capacity = nums.length;
        memo = new Boolean[capacity][target+1];

        for (int i = 0; i <= target; i++) {
            memo[0][i]= nums[0] == i;
        }
        for (int i = 1; i < capacity; i++) {
            for (int j = 0; j <= target; j++) {
                if (j-nums[i]>=0)
                    memo[i][j] = memo[i-1][j] || memo[i-1][j-nums[i]];
                else memo[i][j] = memo[i-1][j];
            }
        }
        return memo[capacity-1][target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution02().canPartition(new int[]{1, 2, 3, 5}));
    }
}
