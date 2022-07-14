package random.sdjpaliquibase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.sdjpaliquibase.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
