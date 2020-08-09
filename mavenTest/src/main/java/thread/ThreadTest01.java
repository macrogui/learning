package thread;

public class ThreadTest01 extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 2000; i++) {
            System.out.println(i+"running......");
        }
    }

    public static void main(String[] args) {
        ThreadTest01 threadTest01 = new ThreadTest01();
        threadTest01.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println(i+"main......");
        }
    }
}
