package datastucture.queue;

import datastucture.array.Array;

/**
 * getSize: O(1)
 * isEmpty: O(1)
 * enqueue: O(1)
 * dequeue: O(n)
 * getFront: O(1)
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        this(10);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ArrayQueue{");
        sb.append("array=").append(array);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        System.out.println(queue);
        queue.enqueue(30);
        queue.enqueue(60);
        queue.enqueue(90);
        System.out.println(queue);
        System.out.println(queue.getFront());
        queue.dequeue();
        System.out.println(queue);
    }
}
