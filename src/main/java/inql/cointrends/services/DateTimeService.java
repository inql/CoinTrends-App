package inql.cointrends.services;

import java.time.LocalDateTime;

public interface DateTimeService {

    Long getMiliseconds(String dateTime);
    LocalDateTime getLocalDateTime(String dateTime);
}
