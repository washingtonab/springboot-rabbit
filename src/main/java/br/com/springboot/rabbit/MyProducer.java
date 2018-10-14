package br.com.springboot.rabbit;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProducer {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@PostConstruct
	public void init() {
		sendMessage();
	}

	public void sendMessage() {
		Message message = new Message("hello my friend".getBytes(), new MessageProperties());
		amqpTemplate.send("teste", message);
	}

}
