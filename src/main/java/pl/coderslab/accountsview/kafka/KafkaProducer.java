package pl.coderslab.accountsview.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import pl.coderslab.accountsview.address.Address;
import pl.coderslab.accountsview.address.AddressDto;

@Service
@Slf4j
public class KafkaProducer {


    @Autowired
    private KafkaTemplate<String, AddressDto> kafkaTemplate;

    public void sendMessage(AddressDto address) {
        log.info(String.format("Message sent -> %s", address.toString()));

        Message<AddressDto> message = MessageBuilder
                .withPayload(address)
                .setHeader(KafkaHeaders.TOPIC, "topic_address")
                .build();

        kafkaTemplate.send(message);
    }
}