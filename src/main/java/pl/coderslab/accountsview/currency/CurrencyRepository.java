package pl.coderslab.accountsview.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.accountsview.accountdeposit.AccountDeposit;
import pl.coderslab.accountsview.carddeposit.CardDeposit;
@Transactional
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Modifying
    @Query("delete from Currency b")
    void deleteCurrencies();
}
