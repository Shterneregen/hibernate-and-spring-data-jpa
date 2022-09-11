package random.jpaliquibase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaliquibase.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
