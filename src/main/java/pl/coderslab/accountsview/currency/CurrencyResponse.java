package pl.coderslab.accountsview.currency;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyResponse
{
    private String numberAccount;
    private String currency;
    private double amount;
    private double amountCurrency;
}