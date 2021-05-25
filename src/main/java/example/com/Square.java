package example.com;

public class Square {
    public void calculate(int n) {
        if(n == 0){
            throw new NotAcceptableNumber();
        }else if(n < 0){
            throw new NotAcceptableNumber();
        }

    }

    static class NotAcceptableNumber extends RuntimeException {

    }

}
