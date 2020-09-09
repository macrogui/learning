package leetcode.p79;

/**
 * 单词搜索，回溯法
 */
public class Solution {
    boolean[][] isVisited;

    public boolean exist(char[][] board, String word) {
        return helper(board, word.toCharArray());
    }

    private boolean helper(char[][] board, char[] words) {
        isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == words[0]) {
                    if (tryFind(board, words, 1, j, i)) return true;
                }
            }
        }
        return false;
    }

    //当前的wordIndex,nowX,nowY是否可以得到这个单词
    private boolean tryFind(char[][] board, char[] words, int wordIndex, int nowX, int nowY) {
        if (isVisited[nowY][nowX])
            return false;
        if (wordIndex == words.length)
            return true;
        isVisited[nowY][nowX] = true;
        boolean success = false;
        if (wordIndex < words.length) {
            boolean b1, b2, b3, b4;
            b1 = b2 = b3 = b4 = false;
            if (nowX - 1 >= 0 && board[nowY][nowX - 1] == words[wordIndex])
                b1 = tryFind(board, words, wordIndex + 1, nowX - 1, nowY);
            if (nowX + 1 < board[0].length && board[nowY][nowX + 1] == words[wordIndex])
                b2 = tryFind(board, words, wordIndex + 1, nowX + 1, nowY);
            if (nowY - 1 >= 0 && board[nowY - 1][nowX] == words[wordIndex])
                b3 = tryFind(board, words, wordIndex + 1, nowX, nowY - 1);
            if (nowY + 1 < board.length && board[nowY + 1][nowX] == words[wordIndex])
                b4 = tryFind(board, words, wordIndex + 1, nowX, nowY + 1);
            success = b1 || b2 || b3 || b4;
        }
        if (!success)
            isVisited[nowY][nowX] = false;
        return success;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}
        }, "ABCEFSADEESE"));
    }
}
