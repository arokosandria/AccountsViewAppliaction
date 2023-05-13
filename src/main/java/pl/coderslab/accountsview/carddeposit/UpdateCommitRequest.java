package pl.coderslab.accountsview.carddeposit;

import javax.validation.constraints.NotBlank;

public record UpdateCommitRequest(@NotBlank String numberCard,
                                  @NotBlank String numberAccount,
                                  @NotBlank String personName,
                                  String name)
                    {
}
