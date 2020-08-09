package thread;

import java.util.concurrent.*;

public class CallableTest implements Callable {

    private String url;
    private String name;

    public CallableTest(String url, String name) {
        this.url = url;
        this.name = name;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String u1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593953893341&di=23c035303887ef852e9406bd20647f79&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201309%2F03%2F20130903141830_Q4Wuc.jpeg";
        String u2 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593953893341&di=7b4253809f070977c57297d349cee340&imgtype=0&src=http%3A%2F%2Fimages.china.cn%2Fattachement%2Fjpg%2Fsite1000%2F20170424%2F7427ea210a2c1a677cda59.jpg";
        String u3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1593953893340&di=499aa04d08b4b20c9e037e5f3421af75&imgtype=0&src=http%3A%2F%2Fimg.improve-yourmemory.com%2Fpic%2F87c9b1405e9c5f4fc106df273a882273-2.jpg";
        String n1 = "1.jpg";
        String n2 = "2.jpg";
        String n3 = "3.jpg";
        CallableTest t1 = new CallableTest(u1, n1);
        CallableTest t2 = new CallableTest(u2, n2);
        CallableTest t3 = new CallableTest(u3, n3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<Object> r1 = executorService.submit(t1);
        Future<Object> r2 = executorService.submit(t2);
        Future<Object> r3 = executorService.submit(t3);

        Object rs1 = r1.get();
        executorService.shutdown();
    }

    @Override
    public Object call() throws Exception {
        WebDownload webDownload = new WebDownload();
        webDownload.download(url, name);
        System.out.println("下载的url: " + url);
        System.out.println("下载的文件名: " + name);
        return null;
    }
}