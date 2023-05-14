package pl.coderslab.accountsview.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.accountsview.carddeposit.CardDepositDto;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/currency")
@Slf4j
@RequiredArgsConstructor

public class CurrencyController {
    private final CurrencyService currencyService;



    @GetMapping("/{numberCard}/{currency}")
    public CurrencyResponse getNumberCardCurrenv(@PathVariable String numberCard,@PathVariable String currency) {
        CurrencyResponse currencyResponse=currencyService.getByNumberAccount(numberCard,currency);
        return currencyResponse;

    }
}
