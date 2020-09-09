package leetcode.p51;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int[] columns;
    private List<List<String>> ret = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        columns = new int[n];
        putQueen(n, 0);
        return ret;
    }

    private void putQueen(int n, int line) {
        if (line == n){
            genboard(n);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(line, i)) {
                columns[line] = i;
                putQueen(n, line + 1);
            }
        }
        return;
    }

    private void genboard(int n) {
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (columns[i]==j)
                    sb.append("Q");
                else sb.append(".");
            }
            arr.add(sb.toString());
        }
        ret.add(arr);
    }

    private boolean isValid(int line, int i) {
        //竖直方向是否重复
        //右下对角线是否重复
        //右上对角线是否重复
        for (int l = 0; l < line; l++) {
            if (columns[l]==i||(columns[l]-l) == i - line||(columns[l]+l) == i + line) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solveNQueens(4));
    }
}
