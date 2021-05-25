package example.com;

public class Square {

    public static final int MAX_SIDE = 1000;

    public int calculate(int n) {
        if(n <= 0 || n > MAX_SIDE){
            throw new NotAcceptableNumber(n);
        }
        return n*n;
    }

    static class NotAcceptableNumber extends RuntimeException {

        public NotAcceptableNumber(int n) {

        }
    }

}
