package datastucture.set;

import datastucture.tree.bst.BST02;

/**
 * add O(h)
 * contains O(h)
 * remove O(h)
 * h为树的高度
 * @param <E>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BST02<E> bst;
    public BSTSet(){
        bst = new BST02<>();
    }
    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
