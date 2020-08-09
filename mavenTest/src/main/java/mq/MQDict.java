package mq;

import java.time.Duration;

public class MQDict {
    public static final String MQ_ADDRESS_COLLECTION = "121.199.67.173:9092";			//kafka地址
    public static final String CONSUMER_TOPIC = "topicDemo";						//消费者连接的topic
    public static final String PRODUCER_TOPIC = "topicDemo";						//生产者连接的topic
    public static final String CONSUMER_GROUP_ID = "1";								//groupId，可以分开配置
    public static final String CONSUMER_ENABLE_AUTO_COMMIT = "true";				//是否自动提交（消费者）
    public static final String CONSUMER_AUTO_COMMIT_INTERVAL_MS = "1000";
    public static final String CONSUMER_SESSION_TIMEOUT_MS = "30000";				//连接超时时间
    public static final int CONSUMER_MAX_POLL_RECORDS = 10;							//每次拉取数
    public static final Duration CONSUMER_POLL_TIME_OUT = Duration.ofMillis(3000);	//拉去数据超时时间

}