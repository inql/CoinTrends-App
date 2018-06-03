package inql.cointrends.services;

import inql.cointrends.domain.CurrencyData;
import inql.cointrends.domain.CurrencySource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
public class ApiServiceImplTest {

    ApiService apiService;

    @Before
    public void setUp() throws Exception {
        apiService = new ApiServiceImpl(new RestTemplateBuilder().build());
    }

    @Test
    public void getCurrencyData() {

        List<CurrencyData> currencyData = apiService.getCurrencyData(CurrencySource.BTCUSD);
        assertNotNull(currencyData);

    }
}