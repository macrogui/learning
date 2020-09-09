package leetcode.p200;

public class Solution {
    private boolean[][] isVisit;
    private int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        isVisit = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isVisit[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (isVisit[i][j]) return;
        isVisit[i][j] = true;
        for (int[] d : direct) {
            if (isValid(grid, i + d[0], j + d[1]) && grid[i + d[0]][j + d[1]] == '1') {
                dfs(grid, i + d[0], j + d[1]);
            }
        }
    }

    private boolean isValid(char[][] grid, int i, int j) {
        return grid.length > i && i >= 0 && grid[0].length > j && j >= 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
//        System.out.println(new Solution().numIslands(new char[][]{{'1', '0', '1', '1', '0', '1', '1'}}));
    }
}
