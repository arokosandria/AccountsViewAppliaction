package pl.coderslab.accountsview.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.coderslab.accountsview.address.Address;
import pl.coderslab.accountsview.address.AddressRepository;


@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final AddressRepository addressRepository;

    @KafkaListener(topics = "topic_address",
            groupId = "groupid")
    public void consume(Address address) {

        Address addressUpdate = addressRepository.findById(address.getId())
                .map(addressExisting -> {
                    if(address.getCity()!=null) {
                        addressExisting.setCity(address.getCity());
                    }
                    return addressExisting;
                }).map(addressRepository::save).orElseThrow(() -> new IllegalArgumentException("No address with address id " + address.getId()));

        log.info(String.format("Message received -> %s", addressUpdate.toString()));
    }
}