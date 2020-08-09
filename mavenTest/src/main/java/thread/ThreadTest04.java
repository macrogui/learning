package thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest04 implements Runnable {

    private Integer ticketNum = 10;
    private List<String> queue = new ArrayList<>();

    public List<String> getQueue() {
        return queue;
    }

    @Override
    public synchronized void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
//            queue.add(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getName() + "--> 第" + ticketNum-- + "张票");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest04 t1 = new ThreadTest04();
        new Thread(t1, "小明").start();
        new Thread(t1, "小张").start();
        new Thread(t1, "黄牛党").start();
//        while (true) {
//            System.out.println(t1.queue);
//            if (t1.ticketNum<=0){
//                break;
//            }
//            if (t1.getQueue().size() > 0 && t1.ticketNum > 0) {
//                System.out.println(t1.getQueue().get(0) + "--> 第" + t1.ticketNum-- + "张票");
//                t1.getQueue().remove(0);
//            }
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
