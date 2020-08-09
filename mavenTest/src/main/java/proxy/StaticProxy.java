package proxy;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new Peter());
        weddingCompany.HappyMarry();
    }
}

interface Marry{
    void HappyMarry();
}

class Peter implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("peter 结婚了");
    }
}

class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("结婚前，布置现场");
    }

    private void after() {
        System.out.println("结婚后，收尾款");
    }
}