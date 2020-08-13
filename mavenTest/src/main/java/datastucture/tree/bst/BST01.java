package datastucture.tree.bst;

/**
 * BST 二分搜索树
 * 这里实现的树不存在重复的元素
 * 每个节点值大于左子树上所有节点的值
 * 每个节点值小于右子树上所有节点的值
 * 问题：
 * 1. 根节点和其他位置插入元素的逻辑不统一
 * 2. 插入元素的时候比较了两次并且判定递归结束也是比较臃肿的{@link BST02}
 * @param <E>
 */
public class BST01<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST01() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 向二分搜索树中添加新的元素e
    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else
            add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    private void add(Node node, E e) {
        if (e.equals(node.e))
            return;
        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else //e.compareTo(node.e) > 0
            add(node.right, e);
    }
}
