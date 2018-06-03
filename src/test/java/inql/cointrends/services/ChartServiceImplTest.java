package inql.cointrends.services;

import inql.cointrends.domain.CurrencyData;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ChartServiceImplTest {

    ChartServiceImpl chartService;
    List<CurrencyData> data;

    @Mock
    ApiService apiService;
    @Mock
    DateTimeService dateTimeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        chartService = new ChartServiceImpl(apiService,dateTimeService);

        data = new LinkedList<>();
    }

    @Test
    public void initData() {
        CurrencyData currencyData = new CurrencyData();
        currencyData.setTime("2017-01-01 12:12:12");
        currencyData.setHigh(2.5);
        currencyData.setAverage(2.3);
        currencyData.setLow(2.1);
        currencyData.setOpen(2);
        currencyData.setVolume(1.0);
        data.add(currencyData);
        assertEquals(chartService.initData(data).size(),1);
    }
}