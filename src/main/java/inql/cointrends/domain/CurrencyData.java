package inql.cointrends.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyData {

    private Double volume;
    private Integer open;
    private Double low;
    private Double average;
    private Double high;
    private String time;

}
