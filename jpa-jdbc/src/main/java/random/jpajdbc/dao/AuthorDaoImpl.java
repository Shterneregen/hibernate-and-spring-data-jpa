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
