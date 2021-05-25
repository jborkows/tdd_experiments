package example.com;

//@Component
public class DirtySolution {

    private final FullEEDB fullEEDB;

    DirtySolution(FullEEDB fullEEDB){
        this.fullEEDB = fullEEDB;
    }

    int calculate(int n){
        return n*n;
    }

    static class FullEEDB implements Repository {
        @Override
        public void saveSquareSide(int n){
            //do nasty work here
        }

        @Override
        public boolean valueExists(int n) {
            //do nasty work here
            return false;
        }
    }
}
