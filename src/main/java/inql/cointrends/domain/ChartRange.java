package inql.cointrends.domain;


import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ChartRange {

    @NotNull
    @NotEmpty
    private String startDate;
    @NotNull
    @NotEmpty
    private String endDate;


}
