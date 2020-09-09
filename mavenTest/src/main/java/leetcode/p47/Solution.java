package leetcode.p47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        helper(Arrays.stream(nums).boxed().collect(Collectors.toCollection(LinkedList::new)), new ArrayList<>());
        return ret.stream().distinct().collect(Collectors.toList());
    }

    private void helper(List<Integer> nums, List<Integer> arr) {
        if (nums.size()==0){
            ret.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            arr.add(cur);
            nums.remove(i);
            helper(nums, arr);
            nums.add(i, cur);
            arr.remove(arr.size()-1);
        }
    }
}
