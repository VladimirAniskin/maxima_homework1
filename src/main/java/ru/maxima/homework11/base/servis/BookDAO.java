package ru.maxima.homework11.base.servis;

import ru.maxima.homework11.base.model.Book;

import java.sql.*;

public class BookDAO {
    public static final String INSERT_BOOK = "insert into public.book (book_name,author) values(?,?)";
    public static final String SELECT_BOOK = "SELECT * FROM public.book WERE id  ?";
    public static final String UPDATE_BOOK = "UPDATE public.book SET book_name= ?, author =? WERE  id = ?";
    public static final String DELETE_BOOK = "DELETE public.book  WERE  id = ?";

    private Connection connection;

    {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/homework11",
                    "postgres",
                    "P@ssword");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Book book) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK);
        preparedStatement.setString(1, book.getBookName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.execute();
    }

    public Book byid(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
        Book book = new Book();
        ResultSet result = preparedStatement.executeQuery();
        while (result.next())
            book.setId(result.getLong("id"));
        book.setBookName("book_name");
        book.setAuthor("author");
        return book;
    }

    public void update(long id, Book book) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK);
        preparedStatement.setString(1, book.getBookName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.setLong(3, id);
        preparedStatement.execute();
    }

    public void delete(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}

