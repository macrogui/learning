package datastucture.set;

import datastucture.linkedList.DummyHeadLinkedList;

/**
 * add O(n)
 * contains O(n)
 * remove O(n)
 *
 * @param <E>
 */
public class LinkedListSet<E> implements Set<E> {

    private DummyHeadLinkedList<E> list;

    public LinkedListSet(){
        list = new DummyHeadLinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
