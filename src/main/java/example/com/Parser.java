package example.com;

public interface Parser {
    int MAX_SIDE = 1000;

    ValidSide parse(int n);

    static Parser provide() {
        return new ParserImpl();
    }
}
