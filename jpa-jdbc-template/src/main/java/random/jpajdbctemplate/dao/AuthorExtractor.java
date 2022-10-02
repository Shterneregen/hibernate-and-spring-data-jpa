package random.jpajdbctemplate.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import random.jpajdbctemplate.domain.Author;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorExtractor implements ResultSetExtractor<Author> {
    @Override
    public Author extractData(ResultSet rs) throws SQLException, DataAccessException {
        rs.next();
        return new AuthorMapper().mapRow(rs, 0);
    }
}
