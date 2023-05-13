package pl.coderslab.accountsview.accountdeposit;

import pl.coderslab.accountsview.person.PersonDto;

import java.util.List;

public interface AccountDepositService {
    AccountDepositDto create(AccountDepositDto accountDepositDto);

    List<AccountDepositDto> getAll();}
