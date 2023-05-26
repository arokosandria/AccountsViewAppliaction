package pl.coderslab.accountsview.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pl.coderslab.accountsview.address.Address;
import pl.coderslab.accountsview.address.AddressDto;
import pl.coderslab.accountsview.address.AddressRepository;



@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final AddressRepository addressRepository;

    @KafkaListener(topics = "topic_address",
            groupId = "groupid")
    public void consume(AddressDto address) {

        AddressDto addressUpdate = addressRepository.findById(address.id())
                .map(addressExisting -> {
                    if (address.city() != null) {
                        addressExisting.setCity(address.city());
                    }
                    if (address.postCode() != null) {
                        addressExisting.setPostCode(address.postCode());
                    }
                    if (address.street() != null) {
                        addressExisting.setStreet(address.street());

                    }
                    if (address.numberFlat() != null) {
                        addressExisting.setNumberFlat(address.numberFlat());
                    }
                    if (address.number() != null) {
                        addressExisting.setNumber(address.number());
                    }
                    return addressExisting;
                }).map(addressRepository::save).map(this::toDto).orElseThrow(() -> new IllegalArgumentException("No address with address id " + address.id()));

        log.info(String.format("Message received -> %s", addressUpdate.toString()));
    }

    private AddressDto toDto(Address address) {
        return new AddressDto(
                address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getNumberFlat(),
                address.getPostCode(),
                address.getCity()


        );
    }
}