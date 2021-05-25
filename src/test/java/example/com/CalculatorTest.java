package example.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void shouldBeAbleToCalculateArea(){
        exec(ValidSide.unsafeOf(1)).expectToBe(1);
        exec(ValidSide.unsafeOf(2)).expectToBe(4);
    }

    Validable exec(ValidSide validSide){
        return new Validable(validSide);
    }

    static class Validable {
        private final ValidSide validSide;

        public Validable(ValidSide validSide) {
            this.validSide = validSide;
        }

        private Calculator provide() {
            return Calculator.provide();
        }


        public void expectToBe(int i) {
            var area = provide().apply(validSide);
            Assertions.assertEquals(i, area);
        }
    }
}
