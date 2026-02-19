package kafka

import org.apache.kafka.clients.consumer.*
import java.time.Duration

class KafkaConsumerHelper {

    static String consumeMessage(String topic) {

        Properties props = new Properties()
        props.put("bootstrap.servers", "localhost:9092")
        props.put("group.id", "katalon-group")
        props.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer")
        props.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer")

        KafkaConsumer<String, String> consumer =
                new KafkaConsumer<>(props)

        consumer.subscribe(Arrays.asList(topic))

        ConsumerRecords<String, String> records =
                consumer.poll(Duration.ofSeconds(10))

        for (ConsumerRecord<String, String> record : records) {
            return record.value()
        }

        consumer.close()
        return null
    }
}
