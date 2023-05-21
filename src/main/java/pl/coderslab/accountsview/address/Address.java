package pl.coderslab.accountsview.address;

import lombok.*;

import javax.persistence.*;

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
        @Column(nullable = false)
        private String street;
        @Column(nullable = false)
        private int number;
        private int numberFlat;
        @Column(nullable = false)
        private String postCode;
        @Column(nullable = false)
        private String city;

    }

