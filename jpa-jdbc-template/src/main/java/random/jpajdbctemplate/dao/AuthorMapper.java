package random.jpajdbctemplate.dao;

import org.springframework.jdbc.core.RowMapper;
import random.jpajdbctemplate.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Author()
                .setId(rs.getLong("id"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"));
    }
}
