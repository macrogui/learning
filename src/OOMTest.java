public class OOMTest {
//    static int count = 0;
    public static void main(String[] args) {
//        count++;
//        System.out.println(count);
//        main(args);
        method(0);
    }

    private static void method(int i) {
        System.out.println(i);
        method(++i);
    }
}
