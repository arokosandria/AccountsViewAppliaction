package pl.coderslab.accountsview.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.coderslab.accountsview.address.Address;
import pl.coderslab.accountsview.address.AddressRepository;

import java.util.Optional;


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
                    if(address.getPostCode()!=null) {
                        addressExisting.setPostCode(address.getPostCode());
                    }
                    if(address.getStreet()!=null) {
                        addressExisting.setStreet(address.getStreet());
                    }
                    if (address.getNumberFlat()!=null) {
                        addressExisting.setNumberFlat(address.getNumberFlat());
                    }
                    if (address.getNumber()!=null) {
                        addressExisting.setNumber(address.getNumber());
                    }
                    return addressExisting;
                }).map(addressRepository::save).orElseThrow(() -> new IllegalArgumentException("No address with address id " + address.getId()));

        log.info(String.format("Message received -> %s", addressUpdate.toString()));
    }
}