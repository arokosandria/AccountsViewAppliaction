package pl.coderslab.accountsview.accountdeposit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/account")
@Slf4j
@RequiredArgsConstructor
public class AccountDepositController {
    private final AccountDepositService accountDepositService;

    @PostMapping
    public ResponseEntity<AccountDepositDto> create(@RequestBody @Valid AccountDepositDto accountDepositDto) {
        AccountDepositDto accountDepositDto1 = accountDepositService.create(accountDepositDto);
        return ResponseEntity.ok(accountDepositDto1);
    }
    @GetMapping
    public List<AccountDepositDto> getAllPersons() {
        List<AccountDepositDto> accountDepositDtos = accountDepositService.getAll();
        return accountDepositDtos;
    }
}
