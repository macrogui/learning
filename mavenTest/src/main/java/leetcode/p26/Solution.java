package leetcode.p26;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=nums[index-1]){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new Solution().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}