package reservingMovieApp;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
