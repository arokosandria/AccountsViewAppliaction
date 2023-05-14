package pl.coderslab.accountsview.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.accountsview.carddeposit.CardDepositDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/currency")
@Slf4j
@RequiredArgsConstructor

public class CurrencyController {
    private final CurrencyService currencyService;


    @PostMapping
    public ResponseEntity<CurrencyDto> create(@RequestBody @Valid CurrencyDto currencyDto) {
        return ResponseEntity.ok(currencyService.create(currencyDto));
    }
}
