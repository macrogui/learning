package leetcode.p416;

import java.util.Arrays;

/**
 * 使用动态规划尝试解决
 * 通过二维数组记录取前n个数字时相加（随意取元素），是否能得到m。
 *
 * 优化：
 * 二维数组只需要两行，因为当前的格子只与上一行有关
 */
public class Solution03 {
    private Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        if (sum%2!=0)
            return false;
        int target = sum / 2;
        int capacity = nums.length;
        memo = new Boolean[2][target+1];

        for (int i = 0; i <= target; i++) {
            memo[0][i]= nums[0] == i;
        }
        for (int i = 1; i < capacity; i++) {
            for (int j = 0; j <= target; j++) {
                if (j-nums[i]>=0)
                    memo[i%2][j] = memo[(i-1)%2][j] || memo[(i-1)%2][j-nums[i]];
                else memo[i%2][j] = memo[(i-1)%2][j];
            }
        }
        return memo[(capacity-1)%2][target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution03().canPartition(new int[]{1,5,11,5}));
    }
}
