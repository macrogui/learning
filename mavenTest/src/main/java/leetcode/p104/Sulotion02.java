package leetcode.p104;

class Solution {
    public int maxDepth(Sulotion.TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}