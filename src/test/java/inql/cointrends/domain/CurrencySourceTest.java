package inql.cointrends.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencySourceTest {

    final String BTCUSD_URL = "https://apiv2.bitcoinaverage.com/indices/global/history/BTCUSD?period=alltime&?format=json";

    @Test
    public void btcUsdTest(){

        assertEquals(CurrencySource.BTCUSD.getAPI_URL(),BTCUSD_URL);
    }


}