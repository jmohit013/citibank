package com.citi;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	
	@RabbitListener(queues = "${amqp.rabbitmq.queue}")
	public void receiveMessage(String message) {
		System.out.println("Consumed the message: " + message);;
	}
}
