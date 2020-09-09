package leetcode.p120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] mem = new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];
        if (triangle.size() == 0){
            return 0;
        }
        return getMin(triangle, 0, 0, mem);
    }


    private int getMin(List<List<Integer>> triangle, int height, int width, Integer[][] mem) {
        if (mem[height][width] != null){
            return mem[height][width];
        }
        int cur = triangle.get(height).get(width);
        if (height == triangle.size() - 1){
            return cur;
        }
        if (height == triangle.size()-2){
            List<Integer> body = triangle.get(triangle.size() - 1);
            return Math.min(body.get(width), body.get(width+1))+cur;
        } else {
            int curVal = Math.min(getMin(triangle, height + 1, width, mem), getMin(triangle, height + 1, width + 1, mem)) + cur;
            mem[height][width] = curVal;
            return curVal;
        }
    }

    public static void main(String[] args) {
        ArrayList<List<Integer>> arr = new ArrayList<>();
        arr.add(Collections.singletonList(-10));
//        arr.add(Arrays.asList(3,4));
//        arr.add(Arrays.asList(6,5,7));
//        arr.add(Arrays.asList(4,1,8,3));
        System.out.println(new Solution().minimumTotal(arr));
    }
}
