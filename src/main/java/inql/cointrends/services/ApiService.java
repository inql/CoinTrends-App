package inql.cointrends.services;

import inql.cointrends.domain.CurrencyData;
import inql.cointrends.domain.CurrencySource;

import java.util.List;

public interface ApiService {

    List<CurrencyData> getCurrencyData(CurrencySource currencySource);
}
