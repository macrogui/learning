package leetcode.p104;

import leetcode.p102.Solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sulotion {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> arr = new ArrayList<>();
            while (size > 0) {
                TreeNode cur = queue.remove();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }
}
