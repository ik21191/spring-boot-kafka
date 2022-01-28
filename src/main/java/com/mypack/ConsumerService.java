package com.mypack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
/***
 * A topic with three partition with three brokers
 * @author Imran Khan
 *
 */
public final class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "myTopic", groupId = "group_id1")
    public void consume1(String message) {
        logger.info("consume1 " + String.format("$$$$ => Consumed message: %s", message));
    }
    
    @KafkaListener(topics = "myTopic2", groupId = "group_id1")
    public void consume2(String message) {
        logger.info("consume2 " + String.format("$$$$ => Consumed message: %s", message));
    }
    
    @KafkaListener(topics = "myTopic2", groupId = "group_id1")
    public void consume3(String message) {
        logger.info("consume3 " + String.format("$$$$ => Consumed message: %s", message));
    }
}