package implementation;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

    // 할인조건 판단을 위한 정보 수집

    private int sequence;               // 순번조건
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;          // 기간조건
    private DiscountConditionType type; // '할인조건의 종류' (composition)

    public enum DiscountConditionType {
        PERIOD,
        SEQUENCE
    }
    
    public boolean isSatisfiedBy(Screening screening){          // Movie가 보낸 isSatisfiedBy 메세지 수신 (시그니쳐가 Screening)
        
        if(type == DiscountConditionType.PERIOD){
            return isSatisfiedByPeriod(screening);
        }
        return isSatisfiedBySequence(screening);
        
    }

    private boolean isSatisfiedBySequence(Screening screening) {    // 순번조건 : screening에서 getSequence()로 가져온 것과 비교하여 boolean 반환
        return screening.getSequence() == sequence;
    }

    private boolean isSatisfiedByPeriod(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
        startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
        endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0 ;
    }                                                               // 기간조건 : 역시 screening에서 getWhenScreened()로 가져온 것과 비교하여 boolean 반환



    
}
