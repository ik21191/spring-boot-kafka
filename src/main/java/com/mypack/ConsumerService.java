package com.mypack;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public final class ConsumerService {
    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(topics = "kafkaTopic", groupId = "group_id")
    public void consume(Object object) {
    	@SuppressWarnings("unchecked")
		ConsumerRecord<String, Object> record = (ConsumerRecord<String, Object>)object;
    	if(record.value() instanceof Employee) {
    		logger.info(String.format("$$$$ => Consumed message: %s", (Employee)record.value()));
    	} else {
    		logger.info(String.format("$$$$ => Consumed message: %s", record.value()));
    	}
    	
    }
}