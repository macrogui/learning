package leetcode.p387;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, -1);
            }
        }
        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("aapple"));
    }
}
