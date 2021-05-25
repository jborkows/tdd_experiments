package example.com;

public interface Calculator {
    int apply(ValidSide validSide);

    static Calculator provide() {
        return new CalculatorImpl();
    }
}
