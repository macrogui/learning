package leetcode.p27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeElement(new int[]{3, 2, 2, 3}, 2));
    }
}