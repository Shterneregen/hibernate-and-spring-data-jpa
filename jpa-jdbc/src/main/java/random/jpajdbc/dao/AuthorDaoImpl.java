package random.jpajdbc.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import random.jpajdbc.domain.Author;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthorDaoImpl implements AuthorDao {
    private final DataSource source;

    @Override
    public Author getById(Long id) {
        Connection connection = null;
        PreparedStatement ps = null;
        // Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = source.getConnection();
            // statement = connection.createStatement();
            // resultSet = statement.executeQuery("SELECT * FROM author where id = " + id);

            ps = connection.prepareStatement("SELECT * FROM author where id = ?");
            ps.setLong(1, id);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return getAuthorFromRS(resultSet);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            close(resultSet);
            close(ps);
            close(connection);
        }

        return null;
    }

    @Override
    public Author findAuthorByName(String firstName, String lastName) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            connection = source.getConnection();
            ps = connection.prepareStatement("SELECT * FROM author where first_name = ? and last_name = ?");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            resultSet = ps.executeQuery();

            if (resultSet.next()) {
                return getAuthorFromRS(resultSet);
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            close(resultSet);
            close(ps);
            close(connection);
        }

        return null;
    }

    @Override
    public Author saveNewAuthor(Author author) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            connection = source.getConnection();
            ps = connection.prepareStatement("INSERT INTO author (first_name, last_name) values (?, ?)");
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.execute();

            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT LAST_INSERT_ID()");

            if (resultSet.next()) {
                Long savedId = resultSet.getLong(1);
                return this.getById(savedId);
            }

            statement.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            close(resultSet);
            close(ps);
            close(connection);
        }

        return null;
    }

    @Override
    public Author updateAuthor(Author author) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            connection = source.getConnection();
            ps = connection.prepareStatement("UPDATE author set first_name = ?, last_name = ? where author.id = ?");
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setLong(3, author.getId());
            ps.execute();

        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            close(resultSet);
            close(ps);
            close(connection);
        }

        return this.getById(author.getId());
    }

    @Override
    public void deleteAuthorById(Long id) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = source.getConnection();
            ps = connection.prepareStatement("DELETE from author where id = ?");
            ps.setLong(1, id);
            ps.execute();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            close(ps);
            close(connection);
        }
    }

    private static Author getAuthorFromRS(ResultSet resultSet) throws SQLException {
        return new Author()
                .setId(resultSet.getLong("id"))
                .setFirstName(resultSet.getString("first_name"))
                .setLastName(resultSet.getString("last_name"));
    }

    private void close(AutoCloseable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
