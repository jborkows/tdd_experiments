package example.com;

public class Square {
    public void calculate(int n) {
        if(n <= 0){
            throw new NotAcceptableNumber(n);
        }

    }

    static class NotAcceptableNumber extends RuntimeException {

        public NotAcceptableNumber(int n) {

        }
    }

}
