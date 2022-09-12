package random.jpajdbc.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import random.jpajdbc.domain.Author;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {
    private final DataSource source;

    @Override
    public Author getById(Long id) {
        Connection connection;
        Statement statement;
        ResultSet resultSet;

        try {
            connection = source.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM author where id = " + id);

            if (resultSet.next()) {
                Author author = new Author();
                author.setId(id);
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));

                return author;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
