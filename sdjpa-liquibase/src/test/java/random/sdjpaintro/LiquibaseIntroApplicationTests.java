package random.sdjpaintro;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import random.sdjpaliquibase.repositories.BookRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class LiquibaseIntroApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testBookRepository() {
        long count = bookRepository.count();
        assertThat(count).isGreaterThan(0);
    }

    @SuppressWarnings("java:S2699")
    @Test
    void contextLoads() {
    }
}
