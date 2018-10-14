package br.com.springboot.rabbit;

import java.io.UnsupportedEncodingException;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

	@RabbitListener(queues = "teste")
	public void processMessage(byte[] body) throws UnsupportedEncodingException {
		String message = new String(body, "UTF-8");
		System.out.println(" [x] Received '" + message + "'");
	}

}
