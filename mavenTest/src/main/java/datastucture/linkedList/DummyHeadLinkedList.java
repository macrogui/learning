package datastucture.linkedList;

/**
 * 普通的链表在对链表中间的元素操作和对链表头元素的操作逻辑不统一，对中间操作需要找到链表前一个节点
 * 通过DummyHeadLinkedList解决这个不统一的问题
 * 添加 O(n)
 * 删除 O(n)
 * 修改 O(n)
 * 查找 O(n)
 * 只对链表头操作 O(1)
 *
 * @param <E>
 */
public class DummyHeadLinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyhead;
    private int size;

    public DummyHeadLinkedList() {
        dummyhead = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //链表中不常用索引，作为练习用
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index不合法");
        }
        //dummyhead为索引是0的前一个节点
        Node prev = dummyhead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    //链表中不常用索引，作为练习用
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index不合法");
        }
        Node current = dummyhead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    //链表中不常用索引，作为练习用
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index不合法");
        }
        Node current = dummyhead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    //链表中是否存在元素e
    public boolean contains(E e) {
        Node current = dummyhead;
        while (current.next != null) {
            current = current.next;
            if (current.e.equals(e)) {
                return true;
            }
        }
        return false;
    }

    //链表中不常用索引，作为练习用
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index不合法");
        }
        Node current = dummyhead;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        Node delNode = current.next;
        current.next = delNode.next;
        //方便gc回收
        delNode.next = null;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        Node prev = dummyhead;
        while (prev.next != null) {
            if (prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyhead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        DummyHeadLinkedList<Integer> list = new DummyHeadLinkedList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(2);
        }
        list.add(5, 666);
        System.out.println(list);
        System.out.println(list.remove(5));
        System.out.println(list);
    }

}
