Highcharts.chart('container', {
    title: {
        text: 'CoinTrends Challenge 2018'
    },
    xAxis: {
        type: 'datetime'
    },
    yAxis: {
        type: 'logarithmic',
        labels:{
            format: '{value} $'
        },
        title: {
            text: 'Exchange rate'
        }
    },
    legend: {
        enabled: true,
        cursor: "pointer",
        horizontalAlign: "center"
    },
    plotOptions: {
        area: {
            marker: {
                radius: 2
            },
            lineWidth: 1,
            states: {
                hover: {
                    lineWidth: 1
                }
            },
            threshold: null
        }
    },
    series: [
        {
            name: 'BTC to USD',
            data: btcToUsd
        },
        {
            name: 'ETH to USD',
            data: ethToUsd
        },
        {
            name: 'LTC to USD',
            data: ltcToUsd
        },
        {
            name: 'Upper Trendline',
            data: trendLine
        }]
});
