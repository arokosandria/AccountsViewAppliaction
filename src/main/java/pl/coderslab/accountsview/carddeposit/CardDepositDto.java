package pl.coderslab.accountsview.carddeposit;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardDepositDto {
    @NotBlank(message = "personName is obligatory")
    private String personName;
    @NotBlank(message = "numberAccount is obligatory")
    private String numberAccount;
    @NotBlank(message = "name is obligatory")
    private String name;
    @NotBlank(message = "numberCard is obligatory")
    private String numberCard;

}
