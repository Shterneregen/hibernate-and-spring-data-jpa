package random.jpajdbctemplate.dao;

import org.springframework.jdbc.core.RowMapper;
import random.jpajdbctemplate.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book()
                .setId(rs.getLong(1))
                .setIsbn(rs.getString(2))
                .setPublisher(rs.getString(3))
                .setTitle(rs.getString(4))
                .setAuthorId(rs.getLong(5));
    }
}
