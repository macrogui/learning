package datastucture.queue;

import java.util.Arrays;

/**
 * 解决基于数组的队列在dequeue时O(n)时间复杂度的问题
 * front == tail 表示队列为空
 * (tail + 1) % capacity == front 表示队列已满
 * 因此在开辟的容量中会浪费掉一个空间
 */
public class CircleArrayQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public CircleArrayQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public CircleArrayQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空队列无法完成出队操作");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空队列无法完成查看队首");
        }
        return data[front];
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CircleArray{");
        sb.append("data=").append(data == null ? "null" : Arrays.asList(data).toString());
        sb.append(", front=").append(front);
        sb.append(", tail=").append(tail);
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {
        CircleArrayQueue<Integer> queue = new CircleArrayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
            System.out.println(queue);
        }
    }
}
