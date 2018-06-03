package inql.cointrends.services;

import inql.cointrends.domain.CurrencyData;
import inql.cointrends.domain.CurrencySource;

import java.util.List;

public interface ChartService {

    List<Object[]> initData(List<CurrencyData> currencySource);

}
