package example.com;

public class Square {
    public void calculate(int n) {
        if(n == 0){
            throw new ZeroIsNotAcceptable();
        }else if(n == -1){
            throw new NegativeIsNotAcceptable();
        }

    }

    static class ZeroIsNotAcceptable extends RuntimeException {

    }

    static class
    NegativeIsNotAcceptable extends RuntimeException {
    }
}
