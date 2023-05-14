package pl.coderslab.accountsview.currency;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.accountsview.carddeposit.CardDeposit;

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
                        .name(currencyDto.name)
                        .currency(currencyDto.currency)
                        .mid(apiNbpClient.getRate(currencyDto.currency).rateDto().get(0).mid())
                        .build();

currencyRepository.save(currency);

        return toDto(currency);
    }
    
    CurrencyDto toDto (Currency currency){
        
        return new CurrencyDto(apiNbpClient.getRate(currency.getCurrency()).rateDto().get(0).mid(),
                apiNbpClient.getRate(currency.getCurrency()).code(),
                currency.getName(),
                currency.getCurrency());
    }
}
