package example.com;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;

public interface SquareInfrastructure {


    default Validable exec(int n) {
        return new Validable(n, new InMemoryRepository());
    }

    class Validable {
        private final int n;
        private final Repository repository;

        public Validable(int n, Repository repository) {
            this.n = n;
            this.repository = repository;
        }

        private Square provide() {
            return new Square(repository);
        }

        void shouldFail() {
            Assertions.assertThrows(Square.NotAcceptableNumber.class, () -> provide().calculate(n));
        }

        private int calculateAndSave() {
            Square provide = provide();
            provide.storeValue(n);
            try {
                return provide.calculate(n);
            } catch (RuntimeException e) {
                throw e;
            }
        }

        public void expectToBe(int i) {
            var area = calculateAndSave();
            Assertions.assertEquals(i, area);
        }


        public void expectToBeStored() {
            calculateAndSave();
            Assertions.assertTrue(repository.valueExists(n), String.format("Value %d should have been stored in DB", n));
        }

        public void expectNotToBeStored() {
            try {
                calculateAndSave();
            } catch (Exception e) {
                ///ignore
            }
            Assertions.assertFalse(repository.valueExists(n), String.format("Value %d should not have been stored in DB", n));
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
