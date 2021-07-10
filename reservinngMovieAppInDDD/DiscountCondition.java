package reservinngMovieAppInDDD;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    
    private DiscountConditionType type;     // 조건 타입 설정
    private int sequence;                   // 순번 조건에서 필요
    private DayOfWeek dayOfWeek;            // 기간 조건에서 필요
    private LocalTime startTime;            // 기간 조건에서 필요
    private LocalTime endTime;              // 기간 조건에서 필요

    public boolean isDiscountable(DiscountCondition condition, Screening screening) {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(condition, screening);
        }
        return isSatisfiedBySequence(condition, screening);
    }

    private boolean isSatisfiedBySequence(DiscountCondition condition, Screening screening) {
        return sequence == screening.getSequence();
    }

    private boolean isSatisfiedByPeriod(DiscountCondition condition, Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&
        startTime.compareTo(screening.getWhenScreened().toLocalTime())<=0 &&
        endTime.compareTo(screening.getWhenScreened().toLocalTime()) >=0;
    }

}


