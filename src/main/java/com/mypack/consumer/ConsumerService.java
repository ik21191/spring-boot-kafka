package com.mypack.consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.mypack.beans.Employee;

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
    
    @KafkaListener(topics = "employeeTopic1", groupId = "group_id1")
    public void comsumeEmployee(Employee employee) {
      logger.info("comsumeEmployee(Employee employee) is called.");
        logger.info("comsumeEmployee " + String.format("$$$$ => Consumed message: %s", employee));
    }
}