import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    static ReentrantLock reentrantLock = new ReentrantLock(true);
    public static void main(String[] args) {
        Thread t1 = new Thread(){
            @Override
            public void run() {
                testSync();
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                testSync();
            }
        };
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
//        t2.start();
    }

    private static void testSync() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            reentrantLock.unlock();
        }
    }

}
