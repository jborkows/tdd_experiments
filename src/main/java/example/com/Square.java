package example.com;

public class Square {

    private final Store store;
    private final Parser parser;
    private final Calculator calculator;

    public Square(Repository repository, Parser parser, Calculator calculator) {
        this.store = new Store(repository);
        this.parser = parser;
        this.calculator = calculator;
    }

    public int calculateAndSave(int n) throws NotAcceptableNumber {
        ValidSide validSide = parser.parse(n);
        store.store(validSide);
        return calculator.apply(validSide);
    }
}
