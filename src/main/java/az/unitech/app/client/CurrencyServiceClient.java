package az.unitech.app.client;

import az.unitech.app.client.model.Currency;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "currency-service", url = "https://third-party-service-url")
public interface CurrencyServiceClient {

    @GetMapping("/api/currency-rates/{currencyPair}")
    List<Currency> getCurrencyRates();

}