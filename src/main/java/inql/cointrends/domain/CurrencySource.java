package inql.cointrends.domain;

public enum CurrencySource {

    BTCUSD("https://apiv2.bitcoinaverage.com/indices/global/history/BTCUSD?period=alltime&?format=json"),
    ETHUSD("https://apiv2.bitcoinaverage.com/indices/global/history/ETHUSD?period=alltime&?format=json"),
    LTCUSD("https://apiv2.bitcoinaverage.com/indices/global/history/LTCUSD?period=alltime&?format=json");

    private final String API_URL;

    CurrencySource(String API_URL){
        this.API_URL = API_URL;
    }

    public String getAPI_URL() {
        return API_URL;
    }
}
