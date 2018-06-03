package inql.cointrends.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ChartRangeTest {

    private ChartRange chartRange;

    @Before
    public void setUp() throws Exception {
        chartRange = new ChartRange();
    }

    @Test
    public void getStartDate() {
        String startDate = "2017-02-02 11:11:11";
        chartRange.setStartDate(startDate);
        assertEquals(startDate,chartRange.getStartDate());
    }

    @Test
    public void getEndDate() {
        String endDate = "2018-02-02 11:11:11";
        chartRange.setEndDate(endDate);
        assertEquals(endDate,chartRange.getEndDate());
    }
}