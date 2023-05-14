package pl.coderslab.accountsview.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.accountsview.accountdeposit.AccountDeposit;
import pl.coderslab.accountsview.carddeposit.CardDeposit;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
