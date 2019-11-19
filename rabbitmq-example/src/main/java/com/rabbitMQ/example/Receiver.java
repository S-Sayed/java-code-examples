package com.rabbitMQ.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Receiver {

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
//			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			
			System.out.println("Waiting for messages");
			
			DeliverCallback deliverCallback = (consumerTag, delivery) -> {
			    String message = new String(delivery.getBody(), "UTF-8");
			    System.out.println("Received: " + message);
			};
			
			channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
