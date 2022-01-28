package com.mypack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public final class ProducerService {
	private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

	private final KafkaTemplate<String, String> kafkaTemplate;
	private final String TOPIC = "myTopic";

	public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		logger.info(String.format("$$$$ => Producing message: %s", message));
		this.kafkaTemplate.send(TOPIC, message);
		/*
		 * ListenableFuture<SendResult<String, String>> future =
		 * this.kafkaTemplate.send(TOPIC, message); future.addCallback(new
		 * ListenableFutureCallback<>() {
		 * 
		 * @Override public void onFailure(Throwable ex) {
		 * logger.info("Unable to send message=[ {} ] due to : {}", message,
		 * ex.getMessage()); }
		 * 
		 * @Override public void onSuccess(SendResult<String, String> result) {
		 * logger.info("Sent message=[ {} ] with offset=[ {} ]", message,
		 * result.getRecordMetadata().offset()); } });
		 */
	}
}