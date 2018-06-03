package inql.cointrends.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CurrencyDataTest {

    CurrencyData currencyData;

    @Before
    public void setUp(){
        currencyData = new CurrencyData();
    }

    @Test
    public void getVolume() {
        Double volume = 2.33;
        currencyData.setVolume(volume);

        assertEquals(volume,currencyData.getVolume());
    }

    @Test
    public void getOpen() {
        Integer open = 4;
        currencyData.setOpen(open);

        assertEquals(open,currencyData.getOpen());

    }

    @Test
    public void getLow() {
        Double low = 1.00;
        currencyData.setLow(low);

        assertEquals(low, currencyData.getLow());
    }

    @Test
    public void getAverage() {
        Double average = 12.34;
        currencyData.setAverage(average);

        assertEquals(average,currencyData.getAverage());
    }

    @Test
    public void getHigh() {
        Double high = 20.33;
        currencyData.setHigh(high);

        assertEquals(high,currencyData.getHigh());
    }

    @Test
    public void getTime() {
        String time = "2017-02-02 12:12:12";
        currencyData.setTime(time);

        assertEquals(time,currencyData.getTime());
    }


}