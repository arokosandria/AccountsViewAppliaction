package pl.coderslab.accountsview.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.accountsview.exception.ResourceNotFoundException;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
@Slf4j
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;



    @GetMapping
    public List<PersonDto> getAllPersons() {
        List<PersonDto> personList = personService.getAll();
        return personList;
    }

    @GetMapping("/{name}")
    public ResponseEntity<PersonDto> getName(@PathVariable String name) {
        PersonDto personDto = personService.getByName(name);
        return ResponseEntity.ok(personDto);
    }

    @PostMapping
    public ResponseEntity<PersonDto> create(@RequestBody @Valid PersonDto personDto) {
        return ResponseEntity.ok(personService.create(personDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonDto> update(@PathVariable Long id, @Valid @RequestBody PersonDto personDto) {
        personDto.setId(id);
        return ResponseEntity.ok(personService.update(personDto));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            personService.delete(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException("Person not found");
        }
    }
    }


