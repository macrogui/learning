package leetcode.p416;

import java.util.Arrays;

/**
 * 使用动态规划尝试解决
 * 通过二维数组记录取前n个数字时相加（随意取元素），是否能得到m。
 *
 * 优化：
 * 进一步只使用一行空间
 *
 */
public class Solution04 {
    private Boolean[] memo;
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).reduce(Integer::sum).getAsInt();
        if (sum%2!=0)
            return false;
        int target = sum / 2;
        int capacity = nums.length;
        memo = new Boolean[target+1];

        for (int i = 0; i <= target; i++) {
            memo[i]= nums[0] == i;
        }
        for (int i = 1; i < capacity; i++) {
            for (int j = target; j >=nums[i]; j--) {
                memo[j] = memo[j] || memo[j-nums[i]];
            }
            //如果memo[target]已经是true了，就不需要再循环了，因为每次循环这个位置将永远为true
            if (memo[target])
                return true;
        }
        return memo[target];
    }

    public static void main(String[] args) {
        System.out.println(new Solution04().canPartition(new int[]{1,5,11,5}));
    }
}
