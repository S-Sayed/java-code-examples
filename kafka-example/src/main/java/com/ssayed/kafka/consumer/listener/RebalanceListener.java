package com.ssayed.kafka.consumer.listener;

import java.util.Collection;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RebalanceListener implements ConsumerRebalanceListener {
	private static final Logger logger = LoggerFactory.getLogger(RebalanceListener.class);

	private Consumer<String, String> consumer;

	public RebalanceListener(Consumer<String, String> consumer) {
		this.consumer = consumer;
	}

	@Override
	public void onPartitionsAssigned(Collection<TopicPartition> topicPartitions) {
		logger.info("Assigned Partitions to this consumer");

		for (TopicPartition topicPartition : topicPartitions) {
			logger.info("topic {}, partition {}", topicPartition.topic(), topicPartition.partition());
		}
	}

	@Override
	public void onPartitionsRevoked(Collection<TopicPartition> topicPartitions) {
		logger.info("Revoked Partitions from this consumer");
		// you can commit what you have before Kafka revoking the Partitions
		for (TopicPartition topicPartition : topicPartitions) {
			logger.info("topic {}, partition {}", topicPartition.topic(), topicPartition.partition());
		}
	}

}
