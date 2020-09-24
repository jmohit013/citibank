package com.citi;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService {

	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${amqp.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${amqp.rabbitmq.routingkey}")
	private String routingkey;	

	public void sendTextMessage(String message) {
		rabbitTemplate.convertAndSend(exchange, routingkey, message);
		System.out.println("Sent text msg = " + message);
	}
}
