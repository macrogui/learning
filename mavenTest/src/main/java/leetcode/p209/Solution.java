package leetcode.p209;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;              //左闭右闭的滑动窗口
        int r = 0;
        int res = nums.length+1;
        int sum = 0;
        while (l < nums.length){
            if (r<nums.length&&sum < s){
                sum += nums[r];
                r++;
            } else if (sum >= s){
                if (res > r - l){
                    res = r - l;
                }
                sum -= nums[l];
                l ++;
            } else {
                break;
            }
        }
        if (res == nums.length+1)
            res = 0;
        return res;
    }

    public static void main(String[] args) {
        new Solution().minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
}
