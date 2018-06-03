package inql.cointrends.services;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class TimeRangeServiceImplTest {

    TimeRangeServiceImpl timeRangeService;

    @Before
    public void setUp() throws Exception {
        timeRangeService = new TimeRangeServiceImpl();
    }

    @Test
    public void changeTimeRange() {
        List<Object[]> data = new LinkedList<>();
        for(int i=0; i<10; i++){
            Object[] record = new Object[2];
            record[0]= (long) ((i + 1) * 1000);
            record[1]= (i+1)*10;
            data.add(record);
        }
        assertEquals(timeRangeService.changeTimeRange(data,1000L,2000L).size(),2);
    }
}