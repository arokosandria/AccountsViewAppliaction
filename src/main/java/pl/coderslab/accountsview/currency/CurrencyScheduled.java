package pl.coderslab.accountsview.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyScheduled {
    private final CurrencyRepository currencyRepository;
    private final ApiNbpClient apiNbpClient;
    private final CurrencyService currencyService;

    @Scheduled(cron = "*/30 * * * * ?")
    public void every30SecondsReadCurrency() {
        currencyService.delete();
        List<String> currencies=List.of("USD","CHF","NOK","RON","SEK");
        for (String currency : currencies) {
            Currency currency1 =
                    Currency.builder()
                            .currency(currency)
                            .mid(apiNbpClient.getRate(currency).rateDto().get(0).mid())
                            .build();
            currencyRepository.save(currency1);
        }
        log.info("Currency write done");

    }
}
