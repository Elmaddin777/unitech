package az.unitech.app.repository.impl;

import az.unitech.app.domain.Currency;
import az.unitech.app.repository.CurrencyRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FakeCurrencyRepositoryImpl implements CurrencyRepository {

    @Override
    public List<Currency> getCurrencies() {
        return getAllCurrencies();
    }

    private List<Currency> getAllCurrencies() {

        return List.of(
                new Currency(
                        "USD",
                        1.7000
                ),

                new Currency(
                        "EUR",
                        1.8707
                )
        );
    }
}
