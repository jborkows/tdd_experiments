package example.com;

import org.junit.jupiter.api.Assertions;

public interface SquareInfrastructure {
    default Square provide(){
        return new Square();
    }

    default Validable exec(int n){
        return new Validable(n);
    }

    class Validable {
        private final int n;

        public Validable(int n) {
            this.n = n;
        }

        private Square provide(){
            return new Square();
        }

        void shouldFail(){
            Assertions.assertThrows(Square.NotAcceptableNumber.class, () -> new Square().calculate(n));
        }

        public void expectToBe(int i) {
            var area = provide().calculate(n);
            Assertions.assertEquals(i, area);
        }
        public void expectToBePositive() {
            var area = provide().calculate(n);
            Assertions.assertTrue(area > 0, String.format("area for %d = %d. Is not a positive number", n, area));
        }
    }
}
