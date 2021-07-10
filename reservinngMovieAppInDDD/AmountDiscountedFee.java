package reservinngMovieAppInDDD;

public class AmountDiscountedFee implements CalculateDiscountFee {

    @Override
    public Money calculateDiscountFee(Movie movie) {
        return movie.getDiscountAmount();
    }
    
}
