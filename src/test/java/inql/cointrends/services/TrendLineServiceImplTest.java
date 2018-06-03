package inql.cointrends.services;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TrendLineServiceImplTest {

    TrendLineServiceImpl trendLineService;

    @Before
    public void setUp() throws Exception {
        trendLineService = new TrendLineServiceImpl();
    }

    @Test
    public void generateTrendLine() {
        List<Object[]> data = new LinkedList<>();
        for(int i=0; i<10; i++){
            Object[] record = new Object[2];
            record[0]= (long) ((i + 1) * 2000);
            record[1]= (double)(i+1)*20;
            data.add(record);
        }

        assertNotNull(trendLineService.generateTrendLine(data));


    }
}