package inql.cointrends.services;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.junit.Assert.*;

public class DateTimeServiceImplTest {

    DateTimeServiceImpl dateTimeService;
    LocalDateTime localDateTime;
    @Before
    public void setUp() throws Exception {
        dateTimeService = new DateTimeServiceImpl();
        localDateTime = LocalDateTime.of(2017,02,02,12,12,12);
    }

    @Test
    public void getMiliseconds() {
        Optional<Long> optionalLong = Optional.of(localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        assertEquals(optionalLong.get(),dateTimeService.getMiliseconds("2017-02-02 12:12:12"));
    }

    @Test
    public void getLocalDateTime() {
        assertEquals(localDateTime,dateTimeService.getLocalDateTime("2017-02-02 12:12:12"));


    }
}