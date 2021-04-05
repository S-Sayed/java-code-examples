package com.ssayed.kafka.producer;

import java.util.Properties;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssayed.kafka.util.Constants;

public class KafkaProducerExample {
	private static Logger logger = LoggerFactory.getLogger(KafkaProducerExample.class);

	private static Properties config = new Properties();

	static {
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_BOOTSTRAP_SERVERS);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1000);
		config.put(ProducerConfig.RETRIES_CONFIG, 1);
	}

	public static void main(String[] args) {
		sendMessageUsingFireAndForgetModel();
		sendMessageUsingSyncSendModel();
		sendMessageUsingAsyncSendModel();
	}

	private static void sendMessageUsingFireAndForgetModel() {
		logger.info("sendMessageUsingFireAndForgetModel - Start");

		try (Producer<String, String> producer = new KafkaProducer<>(config);) {
			for (int i = 0; i < 10; i++) {
				String message = "{\"mobileNo\" : \"050663058" + i
						+ "\", \"message\" : \"Hello from Kafka partition 0 \"}";
				// send message to topic partition 0
				ProducerRecord<String, String> record1 = new ProducerRecord<>(Constants.TOPIC_NAME_NOTIFICATION, 0,
						Constants.MESSAGE_KEY_SMS, message);
				producer.send(record1);

				message = "{\"mobileNo\" : \"050663058" + i + "\",\"message\" : \"Hello from Kafka partition 1\"}";
				// send message to topic partition 1
				ProducerRecord<String, String> record2 = new ProducerRecord<>(Constants.TOPIC_NAME_NOTIFICATION, 1,
						Constants.MESSAGE_KEY_SMS, message);
				producer.send(record2);

				logger.info("Message has been sent successfully using FireAndForgetModel");
			}
		} catch (Exception e) {
			logger.error("Failed to send the message using FireAndForgetModel", e);
		}

		logger.info("sendMessageUsingFireAndForgetModel - End");
	}

	private static void sendMessageUsingSyncSendModel() {
		logger.info("sendMessageUsingSyncSendModel - Start");

		try (Producer<String, String> producer = new KafkaProducer<>(config);) {
			ProducerRecord<String, String> record = new ProducerRecord<>(Constants.TOPIC_NAME_NOTIFICATION,
					Constants.MESSAGE_KEY_SMS, "Hello from kafka");
			Future<RecordMetadata> result = producer.send(record);
			RecordMetadata metaData = result.get();

			logger.info("Message has been sent successfully using SyncSendModel, topic <{}>, partition <{}>",
					metaData.topic(), metaData.partition());
		} catch (Exception e) {
			logger.error("Failed to send the message using SyncSendModel", e);
		}

		logger.info("sendMessageUsingSyncSendModel - End");
	}

	private static void sendMessageUsingAsyncSendModel() {
		logger.info("sendMessageUsingAsyncSendModel - Start");

		try (Producer<String, String> producer = new KafkaProducer<>(config);) {
			ProducerRecord<String, String> record = new ProducerRecord<>(Constants.TOPIC_NAME_NOTIFICATION,
					Constants.MESSAGE_KEY_SMS, "Hello from kafka");

			producer.send(record, (RecordMetadata arg0, Exception e) -> {
				// will be executed by another thread once Kafka broker replied
				if (e != null) {
					logger.error("Something went wrong while sending the message using AsyncSendModelCallback", e);
				} else {
					logger.info("Message has been sent successfully using AsyncSendModelCallback");
				}
			});

			logger.info("AsyncSendModel - Got acknowledgement message from kafka broker");
		} catch (Exception e) {
			logger.error("Failed to send the message using AsyncSendModel", e);
		}

		logger.info("sendMessageUsingAsyncSendModel - End");
	}
}
