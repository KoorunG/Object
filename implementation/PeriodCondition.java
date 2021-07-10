package implementation;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;          // 기간조건

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {   // 생성자 만들기
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
        startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
        endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0 ;
    }                                                               // 기간조건 : 역시 screening에서 getWhenScreened()로 가져온 것과 비교하여 boolean 반환
                                                                    // 마찬가지로 로직을 변경하려면 이 메소드의 내부구현을 수정해야하며 관련된 속성인
                                                                    // dayOfWeek, startTime, endTime 역시 변경해야함
    
}
