package example.com;

import static example.com.Parser.MAX_SIDE;

import java.util.Optional;

public final class ValidSide {
    private final int value;

    private ValidSide(int value) {
        this.value = value;
    }

    public int value(){
        return value;
    }

    //test only
    static ValidSide unsafeOf(int n){
        return of(n).orElse(null);
    }

    public static Optional<ValidSide> of(int n){
        if(n <= 0 || n > MAX_SIDE){
            return Optional.empty();
        }else{
            return Optional.of(new ValidSide(n));
        }
    }
}
