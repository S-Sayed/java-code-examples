package com.rabbitMQ.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

	private static final String QUEUE_NAME = "yasmin-12345";
	private static final String EXCHANGE_NAME = "amq.direct";
	private static final String ROUTING_KEY = "yasmin-routing-key";

	public static void main(String[] args) {
		try {
			System.out.println("started");
			ConnectionFactory factory = new ConnectionFactory();
			factory.setHost("localhost");
			Connection con = factory.newConnection();
			Channel channel = con.createChannel();
			channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, ROUTING_KEY);

			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			String msg = "Hello yasmin";
			channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, msg.getBytes());
			System.out.println("message sent: " + msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
