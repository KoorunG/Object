package reservingMovieApp;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;        // 요일
    private LocalTime startTime;        // 시작시간
    private LocalTime endTime;          // 끝 시간

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&         // 요일이 같으며,
        startTime.compareTo(screening.getStartTime().toLocalTime()) <=0 &&          
        endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;             // 상영시작시간이 startTime과 endTime 사이에 있을 경우 true 반환
    }

    
}
