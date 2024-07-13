package com.konivan.services;

import com.konivan.domain.ProjectInfo;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class ProjectInfoProducer {

    public void putNewProject(ProjectInfo projectInfo) {

        Properties props = new Properties();

        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("acks", "all");
        props.put("retries", "3");
        props.put("max.in.flight.requests.per.connection", "1");

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
    }
}
