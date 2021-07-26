package pracDDD_modify2;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

    private DiscountConditionType type; // enum

    private int sequence;   // 순번조건에 필요한 변수

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;  // 기간조건에 필요한 변수

    // 4. 어떤 할인이 적용 가능한지 검사하는 메소드, 기간조건과 순번조건에 각각 다른 메소드를 호출한다
    // 외부에서 호출 가능해야 하므로 private -> public으로 변경한다
    public boolean isDiscountable(Screening screening){
        if(type == DiscountConditionType.PERIOD){
            return isSatisfiedByPeriod(screening);
        }
        return isSatisfiedBySequence(screening);
    }

    // 4-1. 순번조건에 만족하는지 검사하는 메소드
    private boolean isSatisfiedBySequence(Screening screening) {
        return sequence == screening.getSequence();
    }


    // 4-2. 기간조건에 만족하는지 검사하는 메소드
    private boolean isSatisfiedByPeriod(Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&   
                startTime.compareTo(screening.getWhenScreened().toLocalTime()) <=0 &&
                endTime.compareTo(screening.getWhenScreened().toLocalTime()) >=0;
    }

    
}
