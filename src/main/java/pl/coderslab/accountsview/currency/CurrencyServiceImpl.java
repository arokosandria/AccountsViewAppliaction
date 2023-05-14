package pl.coderslab.accountsview.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.accountsview.carddeposit.CardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final ApiNbpClient apiNbpClient;

    @Override
    @Transactional
    public CurrencyDto create(CurrencyDto currencyDto) {
        Currency currency =
                Currency.builder()
                        .currency(currencyDto.currency)
                        .mid(apiNbpClient.getRate(currencyDto.currency).rateDto().get(0).mid())
                        .build();

        currencyRepository.save(currency);

        return toDto(currency);
    }

    CurrencyDto toDto(Currency currency) {

        return new CurrencyDto(apiNbpClient.getRate(currency.getCurrency()).rateDto().get(0).mid(),
                currency.getCurrency());
    }
    @Scheduled(cron = "*/30 * * * * ?")
    public void every30SecondsReadCurrency() {
        currencyRepository.deleteCurrencies();
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
