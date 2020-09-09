package leetcode.p167;

import java.util.Arrays;

/**
 * 对撞指针
 * 题目保证必定有解，所以可以while true
 * O（n）
 * 
 */
class Solution02 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (true){
            if (numbers[l] + numbers[r] == target)
                return new int[]{l+1, r+1};
            else if (numbers[l] + numbers[r] < target)
                l++;
            else r--;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution02().twoSum(new int[]{2,7,11,15}, 9)));
    }
}