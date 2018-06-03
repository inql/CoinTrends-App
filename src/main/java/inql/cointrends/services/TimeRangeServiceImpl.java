package inql.cointrends.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TimeRangeServiceImpl implements TimeRangeService {

    @Override
    public List<Object[]> changeTimeRange(List<Object[]> currencyData, Long start, Long end) {

        return currencyData.stream().filter(getRangePredicate(start, end))
                .collect(Collectors.toList());

    }

    private Predicate<Object[]> getRangePredicate(Long start, Long end){
        return data ->
                (Long) data[0] >= start && (Long) data[0] <= end;

    }
}
