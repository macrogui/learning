package thread;

public class ThreadTest03 implements Runnable{

    @Override
    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.println(i+"running......");
        }
    }

    public static void main(String[] args) {
        ThreadTest03 threadTest03 = new ThreadTest03();
        Thread thread = new Thread(threadTest03);
        thread.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println(i+"main......");
        }
    }
}
