package kafka

import org.apache.kafka.clients.consumer.*
import java.time.Duration

class KafkaConsumerUtil {

    static String consumeMessage(String topic) {

        Properties props = new Properties()
        props.put("bootstrap.servers", "localhost:9092")
        props.put("group.id", "katalon-group")
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("auto.offset.reset", "earliest")

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)
        consumer.subscribe(Arrays.asList(topic))

        def records = consumer.poll(Duration.ofSeconds(10))

        for (record in records) {
            println "Received: " + record.value()
            return record.value()
        }

        consumer.close()
        return null
    }
}