package reservingMovieApp;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
