package com.citi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducerController {

	@Autowired
	MessageSenderService messageSenderService;
	
	@GetMapping(value="/producer")
	public String sendMessage(@RequestParam("message")String message) {
		messageSenderService.sendTextMessage(message);
		return "Your message sent successfully!!";
	}
}


