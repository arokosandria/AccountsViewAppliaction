package pl.coderslab.accountsview.currency;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class ApiNbpClient {

    private final RestTemplate restTemplate;

    @Value("${api.nbp.main-path}")
    private String apiPath;

    public NbpDto getRate(String currency) {
        String url = apiPath.concat("/a/{currency}");
        NbpDto rate = restTemplate.getForObject(url, NbpDto.class, currency);
        return rate;
    }

}
