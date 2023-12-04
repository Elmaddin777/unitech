package az.unitech.app.repository;

import az.unitech.app.domain.Currency;
import java.util.List;

public interface CurrencyRepository {
    List<Currency> getCurrencies();
}
