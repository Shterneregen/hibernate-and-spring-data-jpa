package random.jpaflyway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import random.jpaflyway.domain.AuthorUuid;
import random.jpaflyway.domain.BookNatural;
import random.jpaflyway.domain.BookUuid;
import random.jpaflyway.domain.composite.AuthorComposite;
import random.jpaflyway.domain.composite.AuthorEmbedded;
import random.jpaflyway.domain.composite.NameId;
import random.jpaflyway.repositories.AuthorCompositeRepository;
import random.jpaflyway.repositories.AuthorEmbeddedRepository;
import random.jpaflyway.repositories.AuthorUuidRepository;
import random.jpaflyway.repositories.BookNaturalRepository;
import random.jpaflyway.repositories.BookRepository;
import random.jpaflyway.repositories.BookUuidRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = "random.jpaflyway.bootstrap")
// By default, @DataJpaTest uses H2, here we say don't replace main db (MySQL) by H2
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MySQLIntegrationTest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorUuidRepository authorUuidRepository;
    @Autowired
    private BookUuidRepository bookUuidRepository;
    @Autowired
    private BookNaturalRepository bookNaturalRepository;
    @Autowired
    private AuthorCompositeRepository authorCompositeRepository;
    @Autowired
    private AuthorEmbeddedRepository authorEmbeddedRepository;

    @Test
    void authorEmbeddedTest() {
        NameId nameId = new NameId("John", "T");
        AuthorEmbedded authorEmbedded = new AuthorEmbedded().setNameId(nameId);

        AuthorEmbedded saved = authorEmbeddedRepository.save(authorEmbedded);
        assertThat(saved).isNotNull();

        AuthorEmbedded fetched = authorEmbeddedRepository.getReferenceById(nameId);
        assertThat(fetched).isNotNull();
    }

    @Test
    void authorCompositeTest() {
        NameId nameId = new NameId("John", "T");
        AuthorComposite authorComposite = new AuthorComposite()
                .setFirstName(nameId.getFirstName())
                .setLastName(nameId.getLastName())
                .setCountry("US");

        AuthorComposite saved = authorCompositeRepository.save(authorComposite);
        assertThat(saved).isNotNull();

        AuthorComposite fetched = authorCompositeRepository.getReferenceById(nameId);
        assertThat(fetched).isNotNull();
    }

    @Test
    void bookNaturalTest() {
        BookNatural bookNatural = new BookNatural().setTitle("My Book");
        BookNatural saved = bookNaturalRepository.save(bookNatural);

        BookNatural fetched = bookNaturalRepository.getReferenceById(saved.getTitle());
        assertThat(fetched).isNotNull();
    }

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
