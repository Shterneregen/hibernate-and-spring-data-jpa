package random.jpajdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import random.jpajdbc.dao.AuthorDao;
import random.jpajdbc.dao.AuthorDaoImpl;
import random.jpajdbc.domain.Author;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"random.jpajdbc.dao"})
@Import({AuthorDaoImpl.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AuthorDaoIntegrationTest {

    @Autowired
    private AuthorDao authorDao;

    @Test
    void testGetAuthor() {
        Author author = authorDao.getById(1L);
        assertThat(author).isNotNull();
    }
}
