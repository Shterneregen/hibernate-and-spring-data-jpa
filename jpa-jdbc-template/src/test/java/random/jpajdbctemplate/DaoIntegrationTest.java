package random.jpajdbctemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ActiveProfiles;
import random.jpajdbctemplate.dao.AuthorDao;
import random.jpajdbctemplate.dao.AuthorDaoImpl;
import random.jpajdbctemplate.dao.BookDao;
import random.jpajdbctemplate.domain.Author;
import random.jpajdbctemplate.domain.Book;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("local")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(AuthorDaoImpl.class)
public class DaoIntegrationTest {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;

    @Test
    void testDeleteBook() {
        Book saved = bookDao.saveNewBook(new Book()
                .setIsbn("1234")
                .setPublisher("Self")
                .setTitle("my book"));

        bookDao.deleteBookById(saved.getId());

        assertThrows(EmptyResultDataAccessException.class, () -> bookDao.getById(saved.getId()));
    }

    @Test
    void updateBookTest() {
        Book saved = bookDao.saveNewBook(new Book()
                .setIsbn("1234")
                .setPublisher("Self")
                .setTitle("my book")
                .setAuthorId(1L));

        saved.setTitle("New Book");
        bookDao.updateBook(saved);

        Book fetched = bookDao.getById(saved.getId());

        assertThat(fetched.getTitle()).isEqualTo("New Book");
    }

    @Test
    void testSaveBook() {
        Book saved = bookDao.saveNewBook(new Book()
                .setIsbn("1234")
                .setPublisher("Self")
                .setTitle("my book")
                .setAuthorId(1L));

        assertThat(saved).isNotNull();
    }

    @Test
    void testGetBookByName() {
        Book book = bookDao.findBookByTitle("Clean Code");
        assertThat(book).isNotNull();
    }

    @Test
    void testGetBook() {
        Book book = bookDao.getById(3L);
        assertThat(book.getId()).isNotNull();
    }


    @Test
    void testDeleteAuthor() {
        Author author = new Author();
        author.setFirstName("john");
        author.setLastName("t");

        Author saved = authorDao.saveNewAuthor(author);

        authorDao.deleteAuthorById(saved.getId());

        assertThrows(EmptyResultDataAccessException.class, () -> authorDao.getById(saved.getId()));
    }

    @Test
    void testUpdateAuthor() {
        Author author = new Author();
        author.setFirstName("john");
        author.setLastName("t");

        Author saved = authorDao.saveNewAuthor(author);

        saved.setLastName("Thompson");
        Author updated = authorDao.updateAuthor(saved);

        assertThat(updated.getLastName()).isEqualTo("Thompson");
    }

    @Test
    void testInsertAuthor() {
        Author author = new Author();
        author.setFirstName("john");
        author.setLastName("t222");

        Author saved = authorDao.saveNewAuthor(author);

        System.out.println("New Id is: " + saved.getId());

        assertThat(saved).isNotNull();
    }

    @Test
    void testGetAuthorByName() {
        Author author = authorDao.findAuthorByName("Craig", "Walls");

        assertThat(author).isNotNull();
    }

    @Test
    void testGetAuthor() {
        Author author = authorDao.getById(1L);

        assertThat(author.getId()).isNotNull();
    }
}
