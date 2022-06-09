package random.sdjpaintro;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import random.sdjpaintro.domain.Book;
import random.sdjpaintro.repositories.BookRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// Guarantees test order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// Minimum persistence context
// Annotation for a JPA test that focuses only on JPA components.
@DataJpaTest
@ComponentScan(basePackages = "random.sdjpaintro.bootstrap")
public class SpringBootJpaTestSlice {

    @Autowired
    private BookRepository bookRepository;

    // By default, Spring Boot rolls back all persisted data after each test.
    // But we can change this behaviour using @Rollback(value = false) or @Commit
    @Commit
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        bookRepository.save(new Book("My Book", "123", "Self"));

        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }
}
