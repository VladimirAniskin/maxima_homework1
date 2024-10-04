package ru.maxima.homework11.base;

import ru.maxima.homework11.base.model.Book;
import ru.maxima.homework11.base.model.Libraly;
import ru.maxima.homework11.base.servis.BookDAO;
import ru.maxima.homework11.base.servis.LibralyDAO;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        BookDAO bookDAO = new BookDAO();
        LibralyDAO libralyDAO = new LibralyDAO();
        Book book1 = new Book(1L, "Властелин Колец", "Толкин");
        bookDAO.create(book1);
        Libraly libraly = new Libraly(1L, "Ленинских внучат");
        libralyDAO.create(libraly);


    }
}
