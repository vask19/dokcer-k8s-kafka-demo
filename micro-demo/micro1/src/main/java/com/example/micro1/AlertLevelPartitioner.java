package com.example.micro1;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

public class AlertLevelPartitioner implements Partitioner {


    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        return 0;
//        int criticalLevelPartition = findCriticalPartitionNumber(cluster, topic);
//        return isCriticalLevel(((Alert) objectKey).getAlertLevel()) ?
//                criticalLevelPartition :
//                findRandomPartition(cluster, topic, objectKey);
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}

