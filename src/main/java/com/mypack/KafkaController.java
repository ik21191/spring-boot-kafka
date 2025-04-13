package com.mypack;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public final class KafkaController {
  private final ProducerService producerService;

  public KafkaController(ProducerService producerService) {
    this.producerService = producerService;
  }

  /***
   * Sample message http://localhost:8080/kafka/publish?message=This is test message
   */
  @GetMapping(value = "/publish")
  public String sendMessageToKafkaTopic(@RequestParam String message) {
    producerService.sendMessage(message);
    return "Message published to Producer";
  }
}
