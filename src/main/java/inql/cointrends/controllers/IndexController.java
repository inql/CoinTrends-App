package inql.cointrends.controllers;

import inql.cointrends.domain.ChartRange;
import inql.cointrends.domain.CurrencyData;
import inql.cointrends.domain.CurrencySource;
import inql.cointrends.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    private final ChartService chartService;
    private final TimeRangeService timeRangeService;
    private final DateTimeService dateTimeService;
    private final TrendLineService trendLineService;
    private final ApiService apiService;
    private final String TIME_PATTERN = " 00:00:00";
    private Long start;
    private Long end;

    public IndexController(ChartService chartService, TimeRangeService timeRangeService, DateTimeService dateTimeService, TrendLineService trendLineService, ApiService apiService) {
        this.chartService = chartService;
        this.timeRangeService = timeRangeService;
        this.dateTimeService = dateTimeService;
        this.trendLineService = trendLineService;
        this.apiService = apiService;
    }

    @GetMapping(value = {"","/","/index"})
    public String getIndexPage(Model model){

        Map<CurrencySource,List<CurrencyData>> cryptocurrencies = new HashMap<>();
        cryptocurrencies.put(CurrencySource.BTCUSD,apiService.getCurrencyData(CurrencySource.BTCUSD));
        cryptocurrencies.put(CurrencySource.ETHUSD,apiService.getCurrencyData(CurrencySource.ETHUSD));
        cryptocurrencies.put(CurrencySource.LTCUSD,apiService.getCurrencyData(CurrencySource.LTCUSD));

        List<Object[]> chartBTCUSD = chartService.initData(cryptocurrencies.get(CurrencySource.BTCUSD));
        List<Object[]> chartETHUSD = chartService.initData(cryptocurrencies.get(CurrencySource.ETHUSD));
        List<Object[]> chartLTCUSD = chartService.initData(cryptocurrencies.get(CurrencySource.LTCUSD));
        List<Object[]> trendLine;

        model.addAttribute("range", new ChartRange());
        model.addAttribute("max",LocalDate.now());
        model.addAttribute("min",dateTimeService.getLocalDateTime(cryptocurrencies.get(CurrencySource.BTCUSD).get(0).getTime()));


        if(start == null && end == null){
            trendLine = trendLineService.generateTrendLine(chartBTCUSD);
            model.addAttribute("btctousd", chartBTCUSD);
            model.addAttribute("ethtousd", chartETHUSD);
            model.addAttribute("ltctousd", chartLTCUSD);
            model.addAttribute("trendline",trendLine);
        }else{
            trendLine = trendLineService.generateTrendLine(timeRangeService.changeTimeRange(chartBTCUSD,start,end));
            model.addAttribute("btctousd", timeRangeService.changeTimeRange(chartBTCUSD,start,end));
            model.addAttribute("ethtousd", timeRangeService.changeTimeRange(chartETHUSD,start,end));
            model.addAttribute("ltctousd", timeRangeService.changeTimeRange(chartLTCUSD,start,end));
            model.addAttribute("trendline",trendLine);
        }



        return "index";
    }

    @PostMapping(value = {"","/","/index"})
    public String getTimeRange(@Valid @ModelAttribute("range") ChartRange chartRange, BindingResult bindingResult){

        if(!bindingResult.hasErrors()){

            String startRange = chartRange.getStartDate() + TIME_PATTERN;
            String endRange = chartRange.getEndDate() + TIME_PATTERN;

            start = dateTimeService.getMiliseconds(startRange);
            end = dateTimeService.getMiliseconds(endRange);

        }

        return "redirect:/";

    }
}
