package example.com;

class ParserImpl implements Parser {
    public ValidSide parse(int n) {
        return ValidSide.of(n).orElseThrow(() -> new NotAcceptableNumber(n));
    }
}
