package pl.coderslab.accountsview.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public record NbpDto (String currency, String code, @JsonProperty("rates")List<RateDto> rateDto){
}
