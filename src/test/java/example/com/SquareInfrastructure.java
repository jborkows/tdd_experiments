package example.com;

import org.junit.jupiter.api.Assertions;

public interface SquareInfrastructure {
    default Square provide(){
        return new Square();
    }

    default Validable exec(int n){
        return new Validable(n, repository);
    }

    class Validable {
        private final int n;
        private final Repository repository;

        public Validable(int n, Repository repository) {
            this.n = n;
            this.repository = repository;
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


        public void expectToBeStored() {
            provide().calculate(n);
            Assertions.assertTrue(repository.valueExists(n), String.format("Value %d should have been stored in DB", n));
        }
    }
}
