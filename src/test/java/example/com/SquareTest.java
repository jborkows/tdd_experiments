package example.com;

import org.junit.jupiter.api.Assertions;
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


}
