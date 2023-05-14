package pl.coderslab.accountsview.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/nbp")
@RestController
@RequiredArgsConstructor
public class ApiNbpController {

    private final ApiNbpClient apiNbpClient;

    @GetMapping("/{currency}")
    public NbpDto getRate(@PathVariable String currency) {
        return apiNbpClient.getRate(currency);
    }
}

