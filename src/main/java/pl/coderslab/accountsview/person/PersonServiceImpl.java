package pl.coderslab.accountsview.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public List<PersonDto> getAll() {
        return personRepository.findAll().stream()
                .map(personMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PersonDto getByName(String name) {
        Person person = personRepository.findByName(name).orElseThrow(() -> new IllegalArgumentException("No person with name " + name));
        return personMapper.toDto(person);

    }

    public PersonDto getById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No id " + id));
        return personMapper.toDto(person);

    }

    @Override
    public PersonDto create(PersonDto personDto) {
        Person person = personRepository.save(personMapper.DtoTo(personDto));
        return personMapper.toDto(person);
    }

    @Override
    public PersonDto update(PersonDto personDto) {
        return personRepository.findById(personDto.getId()).map(existingPerson -> {
                    existingPerson.setFirstName((personDto.getFirstName()));
                    existingPerson.setLastName(personDto.getLastName());
                    if (personDto.getEmail() != null) {
                        existingPerson.setEmail(personDto.getEmail());
                    }
                    return existingPerson;
                }).map(personRepository::save)
                .map(personMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("No person with id " + personDto.getId()));
    }

    @Override
    public void delete(Long id) {
        personRepository.deleteById(id);


    }
}


