package datastucture.timeTest;

import datastucture.stack.ArrayStack;
import datastucture.stack.LinkedListStack;
import datastucture.stack.Stack;

import java.util.Random;

/**
 *  比较链表实现的栈与动态数组实现的栈运行指定数量count的push和pop操作所需要的时间。
 *  动态数组栈需要经常扩容缩容操作，将所有元素复制拷贝到新的数组中，相对耗时
 *  对于LinkedListStack需要包含更多的new操作来开辟内存空间，也是比较耗时
 *  因为LinkedListStack中包含更多的new操作，所以其实这个时间比较很复杂
 *  他们之间时间复杂度都是O(1),在不同的情况下（比如操作系统的优化），哪一种结构快时不一定的，差异不大
 */
public class StackTest {
    private static double test(Stack<Integer> stack, int count){

        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < count ; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for(int i = 0 ; i < count ; i ++)
            stack.pop();

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int count = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time1 = test(arrayStack, count);
        System.out.println("ArrayStack, time: " + time1 + " s");

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time2 = test(linkedListStack, count);
        System.out.println("LinkedListStack, time: " + time2 + " s");

        //
    }

}
