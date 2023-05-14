package pl.coderslab.accountsview.currency;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyDto {
    Double mid;
    String code;
    String name;
    String currency;
}
