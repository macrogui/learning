package leetcode.p350;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            if (! map.containsKey(i)){
                map.put(i, 1);
            } else {
                map.put(i, map.get(i)+1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (map.containsKey(i)){
                res.add(i);
                map.put(i, map.get(i)-1);
                if (map.get(i)==0){
                    map.remove(i);
                }
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
