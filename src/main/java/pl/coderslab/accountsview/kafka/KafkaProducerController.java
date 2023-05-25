package pl.coderslab.accountsview.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.accountsview.address.Address;
import pl.coderslab.accountsview.address.AddressDto;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/kafka")

public class KafkaProducerController {
    @Autowired
    private KafkaProducer kafkaProducer;


    @PutMapping("/update")
    public ResponseEntity<String> publish(@RequestBody @Valid AddressDto address) {
        kafkaProducer.sendMessage(address);

        return ResponseEntity.ok("Message sent to kafka topic");
    }
}