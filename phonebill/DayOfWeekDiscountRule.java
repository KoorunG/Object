package phonebill;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountRule {
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();
    private Duration duration = Duration.ZERO;
    private Money amount = Money.ZERO;

    public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Duration duration, Money amount) {
        this.dayOfWeeks = dayOfWeeks;
        this.duration = duration;
        this.amount = amount;
    }

    public Money calculate(DateTimeInterval interval){  // 주중 할증 요금 계산
        if(dayOfWeeks.contains(interval.getFrom().getDayOfWeek())){
            return amount.times(interval.duration().getSeconds()/duration.getSeconds());    // 주중 요금 계산
        }
        return Money.ZERO;  // 주말은 할증 없으므로 그냥 반환
    }

    
}
