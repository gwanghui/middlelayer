package com.iot.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaReceiver {
    @KafkaListener(groupId = "test",
    topicPartitions = {
            @TopicPartition(topic = "${message.topic.name}", partitionOffsets = @PartitionOffset(partition = "0",initialOffset = "0"))
    }, containerFactory = "stringKafkaListenerContainerFactory"
    )
    public void receiver(@Payload String message) {
        System.out.println("Received Message in group 'test': " + message);
    }
}
