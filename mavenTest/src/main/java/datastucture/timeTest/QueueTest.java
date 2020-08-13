package datastucture.timeTest;

import datastucture.queue.ArrayQueue;
import datastucture.queue.CircleArrayQueue;
import datastucture.queue.LinkedListQueue;
import datastucture.queue.Queue;

import java.util.Random;

/**
 * 比较动态数组实现的队列与循环数组实现的队列运行指定数量count的enqueue和dequeue操作所需要的时间。
 * 动态数组队列在出队操作中每出一次队，后面所有的元素就需要向前挪一个位置，对于整个test方法就是O(n²)的复杂度
 * 循环数组队列在入队和出队操作都是O(1)复杂度，对于整个test方法就是O(n)的复杂度
 * CircleArray的性能与ArrayQueue的性能差异巨大
 * 随着count的增加，在count等于50000时ArrayQueue将耗费80s左右，与此同时CircleArray只需要0.05s
 */
public class QueueTest {
    private static double test(Queue<Integer> q, int count) {

        long startTime = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < count; i++)
            q.enqueue(random.nextInt(Integer.MAX_VALUE));

        for (int i = 0; i < count; i++)
            q.dequeue();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int count = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = test(arrayQueue, count);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        CircleArrayQueue<Integer> circleArray = new CircleArrayQueue<>();
        double time2 = test(circleArray, count);
        System.out.println("circleArray, time: " + time2 + " s");

        //时间复杂度与circlaArray相同
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = test(linkedListQueue, count);
        System.out.println("linkedListQueue, time: " + time3 + " s");
    }

}
