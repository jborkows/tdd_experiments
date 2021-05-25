package example.com;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

public interface SquareInfrastructure {


    default Validable exec(int n){
        return new Validable(n, new InMemoryRepository());
    }

    class Validable {
        private final int n;
        private final Repository repository;

        public Validable(int n, Repository repository) {
            this.n = n;
            this.repository = repository;
        }

        private Square provide(){
            return new Square(repository);
        }

        void shouldFail(){
            Assertions.assertThrows(Square.NotAcceptableNumber.class, () -> provide().calculate(n));
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

    class InMemoryRepository implements Repository {
        private final Set<Integer> db = new HashSet<>();
        @Override
        public void saveSquareSide(int n) {
            db.add(n);
        }

        @Override
        public boolean valueExists(int n) {
            return db.contains(n);
        }
    }
}
