package inql.cointrends.services;

import java.util.List;

public interface TimeRangeService {

    List<Object[]> changeTimeRange(List<Object[]> currencyData, Long start, Long end);

}
