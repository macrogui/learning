package thread;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest05 implements Runnable{

    @Override
    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.println(i+"running......");
        }
    }

    public static void main(String[] args) {
        ThreadTest05 threadTest03 = new ThreadTest05();
        Thread thread = new Thread(threadTest03);
        thread.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println(i+"main......");
        }
    }
}
