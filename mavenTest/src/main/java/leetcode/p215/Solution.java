package leetcode.p215;

import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        swap(nums, 0, new Random().nextInt(nums.length));
        return nums[quickSort(nums, 0, nums.length-1, k)];
    }

    private int quickSort(int[] nums, int l, int r, int k) {
        int initR = r;
        int initL = l;
        int pivotIndex = l;
        while (l != r){
            while (nums[r]>=nums[pivotIndex] && l<r){
                r --;
            }
            while (nums[l]<=nums[pivotIndex] && l<r){
                l++;
            }


            int temp = nums[pivotIndex];
            nums[pivotIndex] = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            pivotIndex = l;
        }
        if (initR-pivotIndex+1==k){
            return pivotIndex;
        } else if (initR-pivotIndex+1>k){
            return quickSort(nums, pivotIndex+1, initR, k);
        } else {
            return quickSort(nums, initL, pivotIndex-1, k-initR+pivotIndex-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findKthLargest(new int[]{3, 1, 5, 6, 3, 8, 9}, 5));
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
