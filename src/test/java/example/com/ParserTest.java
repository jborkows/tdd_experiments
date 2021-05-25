package example.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    void shouldPass() {
        exec(1).shouldNotFail();
        exec(Parser.MAX_SIDE).shouldNotFail();
    }

    @Test
    void shouldFail() {
        exec(-1).shouldFail();
        exec(-2).shouldFail();
        exec(0).shouldFail();
        exec(Parser.MAX_SIDE+1).shouldFail();
    }

    Validable exec(int n) {
        return new Validable(n);
    }

    class Validable {
        private final int n;

        public Validable(int n) {
            this.n = n;
        }

        private Parser provide() {
            return Parser.provide();
        }

        void shouldFail() {
            Assertions.assertThrows(NotAcceptableNumber.class, () -> provide().parse(n));
        }

        void shouldNotFail() {
            var valid = provide().parse(n);
            Assertions.assertNotNull(valid);
            Assertions.assertEquals(n, valid.value());
        }

    }

}
