package random.jpajdbctemplate.dao;

import org.springframework.jdbc.core.RowMapper;
import random.jpajdbctemplate.domain.Author;
import random.jpajdbctemplate.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorMapper implements RowMapper<Author> {
    @Override
    public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        Author author = new Author()
                .setId(rs.getLong("id"))
                .setFirstName(rs.getString("first_name"))
                .setLastName(rs.getString("last_name"));

        try {
            if (rs.getString("isbn") != null) {
                author.setBooks(new ArrayList<>());
                author.getBooks().add(mapBook(rs));

                while (rs.next()) {
                    author.getBooks().add(mapBook(rs));
                }
            }
        } catch (SQLException e) {
            //do nothing
        }

        return author;
    }

    private Book mapBook(ResultSet rs) throws SQLException {
        return new Book()
                .setId(rs.getLong(4))
                .setIsbn(rs.getString(5))
                .setPublisher(rs.getString(6))
                .setTitle(rs.getString(7))
                .setAuthorId(rs.getLong(1));
    }
}
