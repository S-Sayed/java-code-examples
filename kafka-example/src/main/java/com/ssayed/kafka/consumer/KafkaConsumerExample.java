package com.ssayed.kafka.consumer;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssayed.kafka.consumer.listener.RebalanceListener;
import com.ssayed.kafka.util.Constants;

public class KafkaConsumerExample {
	private static final Logger logger = LoggerFactory.getLogger(KafkaConsumerExample.class);
	private static Properties config = new Properties();

	static {
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_BOOTSTRAP_SERVERS);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, Constants.CONSUMER_GROUP_NAME_NOTIFICATION);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	}

	public static void main(String[] args) {
		consumeMessages();
	}

	private static void consumeMessages() {
		try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(config);) {
			RebalanceListener rebalanceListener = new RebalanceListener(consumer);
			consumer.subscribe(Arrays.asList(Constants.TOPIC_NAME_NOTIFICATION), rebalanceListener);

			while (true) {
				ConsumerRecords<String, String> records = consumer.poll(100);

				for (ConsumerRecord<String, String> record : records) {
					logger.info("Recieved Message: {}", record.value());
				}
			}
		} catch (Exception e) {
			logger.error("Error while executing consumeMessages", e);
		}
	}
}
