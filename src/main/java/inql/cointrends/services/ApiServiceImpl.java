package inql.cointrends.services;

import inql.cointrends.domain.CurrencySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import inql.cointrends.domain.CurrencyData;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService{

    private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<CurrencyData> getCurrencyData(CurrencySource currencySource) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(currencySource.getAPI_URL());

        CurrencyData[] response = restTemplate.getForObject(uriComponentsBuilder.build().toString(),CurrencyData[].class);
        return Arrays.asList(response);
    }
}
