package homework10;

import java.util.HashSet;
import java.util.Set;

public class ServisLibraryMemory implements ServisLibrary {
    private Library library;
    private static int count_id = 1;

    private final Book[] books = new Book[10];


    @Override
    public Book create(Book book) {
        System.out.println("Сохраняем книгу на сервере");
        System.out.println(" порядковый номер книги :" + book.getId());
        System.out.println("Наименование книги: " + book.getName());
        System.out.println("Автор книги : " + book.getАuthor());
        book.setId(count_id);
        books[count_id] = book;
        count_id++;
        boolean resultSave = book.canEqual(book);
        System.out.println(resultSave ? "Книга сохранена" : " Неполучилось сохранить книгу");
        return book;
    }

    @Override
    public Book findById(int id) {
        return books[id];
    }

    @Override
    public void update(Book book) {
        books[book.getId()] = book;
        System.out.println("Книга под номером: " + book.getId());
        System.out.println("Обновлена на под названием: " + book.getName());
        System.out.println("Автор: " + book.getАuthor());
    }

    @Override
    public void delete(int id) {
        books[id] = null;
        System.out.println("Удалена книга под № :" + id);
    }


}
