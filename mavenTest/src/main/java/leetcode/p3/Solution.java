package leetcode.p3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        while (l < chars.length){
            if (++r >= chars.length){
                res = Math.max(res, r - l);
                break;
            }
            if (!map.containsKey(chars[r]) || map.get(chars[r])<l){
                map.put(chars[r], r);
                continue;
            } else {
                int cur = map.get(chars[r]);
                if (cur >=l&&cur<=r){
                    map.put(chars[r], r);
                }
                res = Math.max(res, r - l);
                l = cur+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
    }
}
