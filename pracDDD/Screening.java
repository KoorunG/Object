package pracDDD;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;    // 영화에 대한 정보
    private int sequence;   // 순번이 뭔가?
    private LocalDateTime whenScreened; // 언제 상영되는가?

    public Movie getMovie() {
        return movie;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public int getSequence() {
        return sequence;
    }
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }
    public void setWhenScreened(LocalDateTime whenScreened) {
        this.whenScreened = whenScreened;
    }

    
}
