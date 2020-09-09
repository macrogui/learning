package leetcode.p455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = g.length - 1;
        int si = s.length - 1;
        int meet = 0;
        while (gi >= 0 && si >= 0) {
            if (s[si]>=g[gi]){
                gi--;
                si--;
                meet++;
            } else gi++;
        }
        return meet;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }
}
