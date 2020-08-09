public class StaticTest {
    private static Integer a;
    private Integer b;

    public void setA(Integer n){
        StaticTest.a = n;
    }


    public static void main(String[] args) {
        StaticTest s1 = new StaticTest();
        System.out.println(StaticTest.a);
        s1.setA(99);
        System.out.println(StaticTest.a);
    }
}
