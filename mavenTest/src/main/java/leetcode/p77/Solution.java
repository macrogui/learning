package leetcode.p77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    private List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n,k, new LinkedList<>());
        return ret.stream().distinct().collect(Collectors.toList());
    }

    private void helper(int n, int k, LinkedList<Integer> arr) {
        if (n < k){
            return;
        }
//        System.out.printf("从%s个元素中取%s个元素\n", n, k);
//        System.out.println("当前arr: "+ arr);
        if (k == 1){
            arr.addLast(n);
            ret.add(new ArrayList<>(arr));
            for (int i = 1; i <= n; i++) {
                arr.set(arr.size()-1, i);
                ret.add(new ArrayList<>(arr));
            }
            arr.removeLast();
            return;
        }

        helper(n-1, k, arr);

        arr.addLast(n);
        helper(n-1, k-1, arr);
        arr.removeLast();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}