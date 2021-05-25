package example.com;

class CalculatorImpl implements Calculator {
    public int apply(ValidSide validSide) {
        return validSide.value() * validSide.value();
    }
}
