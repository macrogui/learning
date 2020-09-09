package leetcode.p322;

import java.util.Arrays;

public class Solution {

    private boolean[][] memo;

    //用n张货币凑到m元钱
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0)
            return 0;
        if (amount<coins[0])
            return -1;
        //一枚硬币时只有金额正好是1，2，5才能凑齐
        int max = amount / coins[0];
        memo = new boolean[max][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == amount){
                return 1;
            }
            if (amount<coins[i]){
                coins = Arrays.copyOf(coins, i);
                break;
            }
            memo[0][coins[i]] = true;
        }
        for (int i = 1; i < max; i++) {
            for (int j =0; j <=amount; j++) {
                if (!memo[i - 1][j]) {
                    continue;
                }
                for (int coin : coins) {
                    if (j + coin == amount) {
                        return i + 1;
                    } else {
                        if (j + coin < amount) {
                            memo[i][j + coin] = true;
                            memo[i][j] = false;
                        }
                    }
                }
            }
        }
        return amount % coins[0] == 0 ? max : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{2}, 1));
    }
}