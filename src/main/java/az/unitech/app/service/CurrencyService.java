package az.unitech.app.service;

import az.unitech.app.client.CurrencyServiceClient;
import az.unitech.app.domain.Currency;
import az.unitech.app.dto.CurrencyDto;
import az.unitech.app.repository.CurrencyRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyServiceClient client;
    private final CurrencyRepository currencyRepository;
    private final ModelMapper modelMapper;

    @Scheduled(fixedRate = 60000) // Run every 1 minute
    void updateCurrencyRates() {
        // Updating currency rates, this can be done with
        // Local Cache
        // Kafka
        // or DB

        client.getCurrencyRates();
    }

    public List<CurrencyDto> getCurrencies() {
        List<Currency> currencies = currencyRepository.getCurrencies();

        return currencies.stream()
                .map(o -> modelMapper.map(o, CurrencyDto.class))
                .toList();
    }

}
