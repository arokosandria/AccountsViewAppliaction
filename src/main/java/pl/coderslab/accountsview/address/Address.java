package pl.coderslab.accountsview.address;

import lombok.*;
import pl.coderslab.accountsview.person.Person;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Address {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank
        private String street;
        @NotNull
        private int number;
        private int numberFlat;
        @NotBlank
        private String postCode;
        @NotBlank
        private String City;

    }

