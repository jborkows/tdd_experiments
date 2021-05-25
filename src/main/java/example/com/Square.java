package example.com;

import java.util.Optional;

public class Square {

    public static final int MAX_SIDE = 1000;
    private final Repository repository;

    public Square(Repository repository) {
        this.repository = repository;
    }

    public int calculate(int n) {
        Optional<ValidSide> maybeValidSide = ValidSide.of(n);
        repository.saveSquareSide(n);
        return maybeValidSide.map(Square::square).orElseThrow(()->new NotAcceptableNumber(n));
    }

    private static int square(ValidSide validSide) {
        var value = validSide.value();
        return value * value;
    }

    static class NotAcceptableNumber extends RuntimeException {

        public NotAcceptableNumber(int n) {

        }
    }

}
