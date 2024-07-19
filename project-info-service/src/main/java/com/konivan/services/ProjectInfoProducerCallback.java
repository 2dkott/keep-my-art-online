package com.konivan.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Objects;

@Slf4j
public class ProjectInfoProducerCallback implements Callback {

    @Override
    public void onCompletion(RecordMetadata recordMetadata, Exception e) {
        if (Objects.nonNull(e)) {
            log.error("topic {} error", recordMetadata.topic(), e);
        } else {
            log.info("topic = {}, offset = {}, timestamp = {}", recordMetadata.topic(), recordMetadata.offset(), recordMetadata.timestamp());
        }
    }
}
