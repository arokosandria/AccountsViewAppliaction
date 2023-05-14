package pl.coderslab.accountsview.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NbpDto (String currency, String code, @JsonProperty("rates")List<RateDto> rateDto){
}
