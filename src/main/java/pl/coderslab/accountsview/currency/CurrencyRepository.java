package pl.coderslab.accountsview.currency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Modifying
    @Query("delete from Currency b")
    void deleteCurrencies();
    Currency getMidByCurrency(String currency);
}
