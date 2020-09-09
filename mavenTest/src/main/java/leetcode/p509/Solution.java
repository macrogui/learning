package leetcode.p509;

/**
 * 若使用递归在n非常大时，效率很低，复杂度为2的n次方
 */
public class Solution {
    public int fib(int N) {
        int[] arr = new int[N+2];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= N; i++) {
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[N];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fib(42));
    }
}
