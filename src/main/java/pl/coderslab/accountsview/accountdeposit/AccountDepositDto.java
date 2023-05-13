package pl.coderslab.accountsview.accountdeposit;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.accountsview.person.Person;

import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Setter
@Getter
@AllArgsConstructor
public class AccountDepositDto {
    @NotBlank
    private String numberAccount;
    private double balance;
    @NotBlank
    private String nameAccount;
    @NotBlank
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
}
