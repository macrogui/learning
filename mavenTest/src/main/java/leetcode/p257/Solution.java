package leetcode.p257;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    private List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuffer());
        return res;
    }

    private void dfs(TreeNode root, StringBuffer sb) {
        if (root == null)
            return;
        sb.append(root.val);
        if (root.left == null&&root.right==null){
            res.add(sb.toString());
            return;
        }
        if (root.left!=null){
            dfs(root.left, new StringBuffer(sb).append("->"));
        }
        if (root.right!=null){
            dfs(root.right, new StringBuffer(sb).append("->"));        }
    }
}
