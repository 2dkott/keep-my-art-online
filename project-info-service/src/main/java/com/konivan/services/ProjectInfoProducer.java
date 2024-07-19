package com.konivan.services;

import com.konivan.domain.ProjectInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

@Slf4j
public class ProjectInfoProducer {

    public void putNewProject(ProjectInfo projectInfo) throws ExecutionException, InterruptedException {

        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "com.konivan.services.ProjectInfoSerde");
        props.put("acks", "all");
        props.put("retries", "3");
        props.put("max.in.flight.requests.per.connection", "1");

        KafkaProducer<String, ProjectInfo> producer = new KafkaProducer<>(props);
        ProducerRecord<String, ProjectInfo> producerRecord =
                new ProducerRecord<>("project-info",
                        projectInfo.getId(),
                        projectInfo);
        producer.send(producerRecord, new ProjectInfoProducerCallback()).get();
    }
}
