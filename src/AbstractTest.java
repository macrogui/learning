public class AbstractTest extends inner {
    AbstractTest(){
        super();
    }
    public void init(){
        super.init();
        System.out.println("parent init");
    }
    public static void main(String[] args) {
        System.out.println("main");
        AbstractTest abstractTest = new AbstractTest();
        abstractTest.init();
        System.out.println(abstractTest.getInnerInt());
    }
}
abstract class inner{
    private int innerInt = 1;
    inner(){
        System.out.println("inner");
    }
    public void init(){
        System.out.println("inner init");
    }
    public int getInnerInt(){
        return innerInt;
    }
}
