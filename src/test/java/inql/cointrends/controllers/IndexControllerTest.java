package inql.cointrends.controllers;

import inql.cointrends.domain.ChartRange;
import inql.cointrends.domain.CurrencyData;
import inql.cointrends.services.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IndexControllerTest {

    IndexController indexController;
    MockMvc mockMvc;
    ApiService apiService;
    ChartRange chartRange;
    @Mock
    ChartService chartService;
    @Mock
    TimeRangeService timeRangeService;
    @Mock
    DateTimeService dateTimeService;
    @Mock
    TrendLineService trendLineService;
    @Mock
    Model model;
    @Mock
    BindingResult bindingResult;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        apiService = new ApiServiceImpl(new RestTemplateBuilder().build());
        chartRange = new ChartRange();
        indexController = new IndexController(chartService,timeRangeService,dateTimeService,trendLineService,apiService);

        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void returnViewTest() throws Exception {
        mockMvc.perform(get("/")).
                andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void getIndexPage() {

        List<CurrencyData> data = new LinkedList<>();
        CurrencyData currencyData = new CurrencyData();
        currencyData.setVolume(2.00);
        currencyData.setOpen(1);
        currencyData.setLow(1.00);
        currencyData.setAverage(2.00);
        currencyData.setHigh(3.00);
        currencyData.setTime("2017-02-02 11:11:11");
        List<Object[]> returnData = new LinkedList<>();
        Object[] test = new Object[2];
        test[0] = 1486030271000L;
        test[1] = 2.00;
        returnData.add(test);

        when(chartService.initData(data)).thenReturn(returnData);

        ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(List.class);

        String viewName = indexController.getIndexPage(model);

        assertEquals(viewName,"index");
    }

    @Test
    public void getTimeRange() throws Exception {

        mockMvc.perform(post("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));

    }
}