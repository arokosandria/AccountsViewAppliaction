package pl.coderslab.accountsview.carddeposit;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CardDepositDto {
    @NotBlank
    private String personName;
    @NotBlank
    private String numberAccount;
    @NotBlank
    private String name;
    @NotBlank
    private String numberCard;

}
