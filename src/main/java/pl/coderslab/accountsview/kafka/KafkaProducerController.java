package pl.coderslab.accountsview.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.accountsview.address.Address;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kafka")

public class KafkaProducerController {
    @Autowired
    private KafkaProducer kafkaProducer;


    @PostMapping("/update")
    public ResponseEntity<String> publish(@RequestBody Address address) {
        kafkaProducer.sendMessage(address);

        return ResponseEntity.ok("Message sent to kafka topic");
    }
}