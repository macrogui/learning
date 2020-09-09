package leetcode.p118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(1);
            for (int j = 1; j < ret.size(); j++) {
                arr.add(ret.get(ret.size()-1).get(j-1) + ret.get(ret.size()-1).get(j));
            }
            if (i > 0)
                arr.add(1);
            ret.add(arr);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(6));
    }
}
