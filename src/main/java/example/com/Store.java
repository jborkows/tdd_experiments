package example.com;

public final class Store {
    private final Repository repository;

    public Store(Repository repository) {
        this.repository = repository;
    }

    public void store(ValidSide n){
        repository.saveSquareSide(n.value());
    }
}
