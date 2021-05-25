package example.com;

import org.junit.jupiter.api.Test;

public class SquareTest implements SquareInfrastructure {

    @Test
    void shouldNotAcceptZeros() {
        exec(0).shouldFail();
    }

    @Test
    void shouldNotAcceptNegatives() {
        exec(-1).shouldFail();
        exec(-2).shouldFail();
    }

    @Test
    void shouldBeAbleToCalculateArea(){
        exec(1).expectToBe(1);
        exec(2).expectToBe(4);
    }

    @Test
    void testCalculatingForVeryLargeNumber(){
        exec(Square.MAX_SIDE + 1).shouldFail();
    }

}
