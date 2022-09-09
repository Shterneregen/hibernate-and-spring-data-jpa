package random.sdjpaflyway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import random.sdjpaflyway.domain.AuthorUuid;
import random.sdjpaflyway.domain.BookUuid;
import random.sdjpaflyway.repositories.AuthorUuidRepository;
import random.sdjpaflyway.repositories.BookRepository;
import random.sdjpaflyway.repositories.BookUuidRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = "random.sdjpaflyway.bootstrap")
// By default, @DataJpaTest uses H2, here we say don't replace main db (MySQL) by H2
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MySQLIntegrationTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorUuidRepository authorUuidRepository;
    @Autowired
    private BookUuidRepository bookUuidRepository;

    @Test
    void testBookUuid() {
        BookUuid bookUuid = bookUuidRepository.save(new BookUuid());
        assertThat(bookUuid).isNotNull();
        assertThat(bookUuid.getId()).isNotNull();

        BookUuid fetched = bookUuidRepository.getReferenceById(bookUuid.getId());
        assertThat(fetched).isNotNull();
    }

    @Test
    void testAuthorUuid() {
        AuthorUuid authorUuid = authorUuidRepository.save(new AuthorUuid());
        assertThat(authorUuid).isNotNull();
        assertThat(authorUuid.getId()).isNotNull();

        AuthorUuid fetched = authorUuidRepository.getReferenceById(authorUuid.getId());
        assertThat(fetched).isNotNull();
    }

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }
}
