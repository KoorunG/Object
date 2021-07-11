package query;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {
    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    public boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek() || !from.toLocalTime().equals(schedule.getFrom())
                || !duration.equals(schedule.getDuration())) {
            reschedule(schedule);       // 상태를 바꾸는 명령
            return false;               // 값을 반환하는 쿼리
        }                               // 명령과 쿼리가 같이 있기때문에 Test단계에서 이 메소드를 여러번 호출하면 오류가 발생할 수밖에 없다.

        return true;
    }

    private void reschedule(RecurringSchedule schedule) {       // 명령 메소드
        from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)),schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long daysDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }


}
