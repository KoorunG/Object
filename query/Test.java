package query;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.time.Duration;

public class Test {
    public static void main(String[] args) {


            Event meeting = new Event("회의", LocalDateTime.of(2019, 5, 8, 10, 30), Duration.ofMinutes(30));
                // 2019년 5월 8일 10시 30분부터 30분간 열리는 회의 (특정 이벤트)
                
                RecurringSchedule schedule = new RecurringSchedule("회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30));
                // 수요일 10시 30분마다 30분간 열리는 회의 (일상적인 일)
        
                assert meeting.isSatisfied(schedule) == true;   
                
                // assert expression1 : 인자로 boolean으로 평가되는 값을 받아서 참이면 지나가고 거짓이면 AssertionError 예외가 발생
        
    }
}
