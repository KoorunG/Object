package reservinngMovieAppInDDD;

public class PercentDiscountedFee implements CalculateDiscountFee{

    @Override
    public Money calculateDiscountFee(Movie movie) {
        return movie.getFee().times(movie.getDiscountPercent());
    }
    
}
