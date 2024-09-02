package homework10;

public interface ServisLibrary {
    Book create(Book book) throws InterruptedException;

    Book findById(int id);

    void update(Book book);

    void delete(int id);
}


