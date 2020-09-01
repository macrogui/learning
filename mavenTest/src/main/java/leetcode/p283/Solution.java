package leetcode.p283;

import java.util.Arrays;

class Solution {
    public void moveZeroes(int[] nums) {
        int offset = 0;
        for (int i = 0; i < nums.length-offset; i++) {
            while (nums[i+offset] == 0){
                if (i + offset + 1 == nums.length){
                    break;
                }
                offset++;
            }
            nums[i] = nums[i+offset];

        }
        for (int i = nums.length-offset; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0,1,0,3,12};
        new Solution().moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
    }
}