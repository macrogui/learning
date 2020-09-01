package leetcode.p75;

public class Solution {
    public void sortColors(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two;) {
            if (nums[i] == 1)
                i++;
            else if (nums[i] == 2){
                swap(nums, i, --two);
            }
            else {
                swap(nums, i++, ++zero);
            }
        }
    }

    private void swap(int[] nums, int i, int two) {
        int temp = nums[i];
        nums[i] = nums[two];
        nums[two] = temp;
    }
}
