package ru.maxima.homework11.base.servis;

import ru.maxima.homework11.base.model.Book;
import ru.maxima.homework11.base.model.Libraly;

import java.sql.*;

public class CommunicationDAO {
    private Connection connection;
    public static final String INSERT_BOOK_AND_LIBRALY = "insert into public.sequence (book_id,libraly_id) values(?,?)";
    public static final String SELECT_lIBRALYID = "SELECT * FROM public.libraly WERE id * (SELECT libraly_id FROM" +
            "public.sequence WERE book_id *(SELECT book_id FROM public.book  WERE book_name= ?) ) ?";

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

    public void create(long book_id, long libraly_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_AND_LIBRALY);
        preparedStatement.setLong(1, book_id);
        preparedStatement.setLong(2, libraly_id);
        preparedStatement.execute();
    }

    public Libraly byLibraly(String bookName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_lIBRALYID);
        preparedStatement.setString(1, bookName);
        preparedStatement.execute();
        Libraly libraly = new Libraly();
        ResultSet result = preparedStatement.executeQuery();
        while (result.next())
            libraly.setId(result.getLong("id"));
        libraly.setLibraly("libraly");

        return libraly;
    }

}
