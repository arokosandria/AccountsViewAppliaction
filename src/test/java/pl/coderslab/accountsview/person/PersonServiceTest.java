package pl.coderslab.accountsview.person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.coderslab.accountsview.address.Address;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

public class PersonServiceTest {

    private PersonService personService;
    private PersonRepository personRepository;
    private PersonMapper personMapper;

    @BeforeEach
    public void setUp() {
        personMapper = new PersonMapperImpl();
        personRepository = Mockito.mock(PersonRepository.class);
        personService = new PersonServiceImpl(personRepository, personMapper);
    }

    @Test
    public void givenPerson_whenFindByName_thenFindPerson() {
        Address address = new Address(1L, "Czachowskiego", 12, 3, "27-900", "krakow");
        Person person = new Person(1L, "konto_numer1", "karolina.mrowka@interia.pl", LocalDate.parse("2014-03-18"), "karolina", "mrowka", "73120639665", address);

        when(personRepository.findByName("konto_numer1")).thenReturn(Optional.of(person));
        PersonDto person1 = personService.getByName("konto_numer1");
        assertEquals(person.getName(), person1.getName());
    }

    @Test
    public void givenPerson_whenFindName_thenFindPerson() {
        Mockito.when(personRepository.findByName("konto"))
                .thenReturn(Optional.of(new Person(null, "konto", null, null, null, null, null, null)));

        PersonDto actual = personService.getByName("konto");

        assertEquals("konto", actual.getName());
    }
}
