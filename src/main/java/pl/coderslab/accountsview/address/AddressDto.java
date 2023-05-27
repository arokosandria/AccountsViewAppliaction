package pl.coderslab.accountsview.address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record AddressDto(
        @NotNull(message = "id nie moze byc puste")
        Long id,
        String street,
        Integer number,
        Integer numberFlat,
        String postCode,
        String city) {
}
