package com.mypack;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public final class KafkaController {
    private final ProducerService producerService;

    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    /***  sample jSon
	{
	    "id":"104",
	    "firstName":"Raj",
	    "lastName":"Kumar"

	}
	*/
    @PostMapping(value = "/publish",consumes = {"application/json"}, produces = {"application/json"})
    public void sendMessageToKafkaTopic(@RequestBody Employee employee) {
    	producerService.sendMessage(employee);
    }
}