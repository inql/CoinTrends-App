package inql.cointrends.services;

import inql.cointrends.domain.CurrencyData;
import inql.cointrends.domain.CurrencySource;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ChartServiceImpl implements ChartService {

    private final ApiService apiService;
    private final DateTimeService dateTimeService;

    public ChartServiceImpl(ApiService apiService, DateTimeService dateTimeService) {
        this.apiService = apiService;
        this.dateTimeService = dateTimeService;
    }

    @Override
    public List<Object[]> initData(List<CurrencyData> currencySource) {

        List<Object[]> data = new LinkedList<>();

        currencySource.stream().iterator().forEachRemaining(currency -> {
            Object[] currencyData = new Object[2];
            currencyData[0] = dateTimeService.getMiliseconds(currency.getTime());
            currencyData[1] = currency.getAverage();

            data.add(currencyData);
        });
        return data;
    }
}
