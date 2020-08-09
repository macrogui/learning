import org.apache.hadoop.yarn.lib.ZKClient;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.codehaus.jackson.map.ser.std.SerializableSerializer;
import org.junit.Test;
import java.io.IOException;
import java.io.Serializable;

public class zooKeeperTest {
    private static final String ZOOKEEPER_IP_PORT = "loaclhost:2181";
//    private ZKClient zkClient = new ZKClient(ZOOKEEPER_IP_PORT, 1000, 1000);
    private ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 9999, new Watcher() {
        public void process(WatchedEvent watchedEvent) {
            System.out.println(watchedEvent);
        }
    });

    public zooKeeperTest() throws IOException {
    }

//    @Test
//    public void watchTest(){
//        String path = "/watcher";
//        this.zooKeeper.subscribeDataChanges
//    }
}
