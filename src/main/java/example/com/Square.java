package example.com;

public class Square {
    public void calculate(int n) {
        throw new ZeroIsNotAcceptable();
    }

    static class ZeroIsNotAcceptable extends RuntimeException{

    }
}
