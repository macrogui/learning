package leetcode.p167;

import java.util.Arrays;

/**
 * 二分搜索法
 *
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int r1 = numbers[i];
            int r2 = binarySearch(numbers, target - r1, i + 1);
            if (r2 != -1){
                return new int[]{i+1, r2+1};
            }
        }
        return new int[]{};
    }

    private int binarySearch(int[] numbers, int target, int start) {
        int l = start;
        int r = numbers.length-1;
        int mid;
        while (l<=r){
            mid = (l+r)/2;
            if (numbers[mid] == target){
                return mid;
            }
            else if (numbers[mid] < target){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2,7,11,15}, 9)));
    }
}