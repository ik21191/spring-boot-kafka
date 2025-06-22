package com.mypack.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mypack.beans.Employee;
import com.mypack.producer.ProducerService;

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
    //sending employee
    return "Message published to Producer";
  }
  
  @PostMapping(value = "/publish-employee")
  public String sendEmployeeMessageToKafkaTopic(@RequestBody Employee employee) {
    producerService.employeeMessage(employee);
    //sending employee
    return "Message published to Producer";
  }
}
