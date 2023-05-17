package pl.coderslab.accountsview.carddeposit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.coderslab.accountsview.exception.ResourceNotFoundException;
import pl.coderslab.accountsview.person.PersonDto;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/card")
@Slf4j
@RequiredArgsConstructor
public class CardDepositController {
    private final CardDepositService cardDepositService;

    @PostMapping
    public ResponseEntity<CardDepositDto> create(@RequestBody @Valid CardDepositDto cardDepositDto) {
        return ResponseEntity.ok(cardDepositService.create(cardDepositDto));
    }

    @GetMapping
    public List<CardDepositDto> getAllCardDeposit() {
        List<CardDepositDto> cardDepositDtoList = cardDepositService.getAll();
        return cardDepositDtoList;

    }
    @GetMapping("/{numberCard}")
    public ResponseEntity<CardDepositDto> getNumberCard(@PathVariable String numberCard) {
        Optional<CardDepositDto> cardDepositDto = cardDepositService.getByNumberCard(numberCard);
        return cardDepositDto.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{numberCard}")
    public ResponseEntity<CardDepositDto> updateCommit(
            @PathVariable String numberCard, @RequestBody @Valid UpdateCommitRequest request) {
        if (!numberCard.equals(request.numberCard())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "NumberCard mismatch");
        }
        CardDepositDto cardDepositDto = cardDepositService.update(request);
        return ResponseEntity.ok(cardDepositDto);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
           cardDepositService.delete(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new ResourceNotFoundException("Cards not found","10023");
        }
    }

}
