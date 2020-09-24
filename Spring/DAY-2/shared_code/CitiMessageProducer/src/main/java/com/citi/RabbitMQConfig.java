package com.citi;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${amqp.rabbitmq.queue}")
	public String queueName; //amqp.queue

	@Value("${amqp.rabbitmq.exchange}")
	public String exchangeName;

	@Value("${amqp.rabbitmq.routingkey}")
	public String routingKey;
	
	@Bean
	public Queue queue() {
		return new Queue(queueName, false);
	}
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(exchangeName);
	}
	
	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(routingKey);
	}
	
	@Bean
	public AmqpTemplate rabbitTemplate2(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		return rabbitTemplate;
	}
}










