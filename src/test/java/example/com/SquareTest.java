package example.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SquareTest {

    @Test
    void shouldNotAcceptZeros(){
        Assertions.assertThrows(Square.ZeroIsNotAcceptable.class, ()-> new Square().calculate(0));
    }

}
