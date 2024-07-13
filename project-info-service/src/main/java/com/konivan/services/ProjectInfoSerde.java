package com.konivan.services;

import com.konivan.domain.ProjectInfo;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public class ProjectInfoSerde implements Serializer<ProjectInfo>, Deserializer<ProjectInfo> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, ProjectInfo projectInfo) {
        return projectInfo.getId().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, ProjectInfo data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }

    @Override
    public ProjectInfo deserialize(String s, byte[] bytes) {
        return null;
    }

    @Override
    public ProjectInfo deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public ProjectInfo deserialize(String topic, Headers headers, ByteBuffer data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }
}
