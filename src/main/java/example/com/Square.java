package example.com;

public class Square {
    public int calculate(int n) {
        if(n <= 0){
            throw new NotAcceptableNumber(n);
        }
        return n*n;
    }

    static class NotAcceptableNumber extends RuntimeException {

        public NotAcceptableNumber(int n) {

        }
    }

}
