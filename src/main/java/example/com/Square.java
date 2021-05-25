package example.com;

import java.util.Optional;

public class Square {

    public static final int MAX_SIDE = 1000;
    private final Repository repository;

    public Square(Repository repository) {
        this.repository = repository;
    }

    public int calculate(int n) {
        return ValidSide.of(n).map(Square::square).orElseThrow(()->new NotAcceptableNumber(n));
    }

    public void storeValue(int n){
        ValidSide.of(n).ifPresent(v->repository.saveSquareSide(v.value()));
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
