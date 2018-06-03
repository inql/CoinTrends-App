package inql.cointrends.services;

import java.util.List;

public interface TrendLineService {

    List<Object[]> generateTrendLine(List<Object[]> input);

}
