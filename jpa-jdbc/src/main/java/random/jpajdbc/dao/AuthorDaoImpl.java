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
                Author author = new Author();
                author.setId(id);
                author.setFirstName(resultSet.getString("first_name"));
                author.setLastName(resultSet.getString("last_name"));

                return author;
            }
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                // if (statement != null) {
                //     statement.close();
                // }

                if (ps != null) {
                    ps.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                log.error(e.getMessage(), e);
            }
        }

        return null;
    }
}
