package leetcode.p66;

import java.util.Arrays;

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                break;
            } else digits[i] = 0;
        }
        if (digits[0]==0){
            int[] ret = new int[digits.length+1];
            ret[0] = 1;
            System.arraycopy(digits, 0, ret, 1, digits.length);
            return ret;
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9,9})));
    }
}
