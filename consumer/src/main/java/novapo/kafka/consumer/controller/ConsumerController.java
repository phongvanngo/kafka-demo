package novapo.kafka.consumer.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConsumerController {


    @KafkaListener(topics = "topic_demo")
    public void listen(
            String message) {
        System.out.println("Received Message: " + message);
    }

//    @KafkaListener(topics = "topic_demo")
//    public void listenWithHeaders(
//            @Payload String message,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        System.out.println(
//                "Received Message: " + message
//                        + " from partition: " + partition);
//    }
//
//
//    @KafkaListener(
//            topicPartitions = @TopicPartition(topic = "topic_demo",
//                    partitionOffsets = {
//                            @PartitionOffset(partition = "0", initialOffset = "0"),
//                            @PartitionOffset(partition = "3", initialOffset = "0")}),
//            containerFactory = "partitionsKafkaListenerContainerFactory")
//    public void listenToPartition(
//            @Payload String message,
//            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        System.out.println(
//                "Received Message: " + message
//                        + "from partition: " + partition);
//    }


}
