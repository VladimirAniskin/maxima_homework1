package ru.maxima.homework11.base.servis;

import ru.maxima.homework11.base.model.Book;
import ru.maxima.homework11.base.model.Libraly;

import java.sql.*;

public class LibralyDAO {
    public static final String INSERT_lIBRALY = "insert into public.libraly (libraly) values(?)";
    public static final String SELECT_lIBRALY = "SELECT * FROM public.libraly WERE id  ?";
    public static final String UPDATE_lIBRALY = "UPDATE public.libraly SET libraly= ?  WERE  id = ?";
    public static final String DELETE_lIBRALY = "DELETE public.libraly  WERE  id = ?";

    Connection connection;

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

    public void create(Libraly libraly) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_lIBRALY);
        preparedStatement.setString(1, libraly.getLibraly());
        preparedStatement.execute();
    }

    public Libraly byid(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_lIBRALY);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
        Libraly libraly = new Libraly();
        ResultSet result = preparedStatement.executeQuery();
        while (result.next())
            libraly.setId(result.getLong("id"));
        libraly.setLibraly("libraly");

        return libraly;
    }

    public void update(long id, Libraly libraly) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_lIBRALY);
        preparedStatement.setString(1, libraly.getLibraly());
        preparedStatement.setLong(2, id);
        preparedStatement.execute();
    }

    public void delete(long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_lIBRALY);
        preparedStatement.setLong(1, id);
        preparedStatement.execute();
    }
}
