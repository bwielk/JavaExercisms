import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

class Gigasecond {

    private LocalDateTime moment;

    Gigasecond(LocalDate moment) {
       this.moment = moment.atStartOfDay();
    }

    Gigasecond(LocalDateTime moment) {
       this.moment = moment;
    }

    LocalDateTime getDateTime() {
        long secondsToAdd = 1000000000;
        return moment.plusSeconds(secondsToAdd);
    }
}
