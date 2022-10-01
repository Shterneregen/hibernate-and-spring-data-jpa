package random.jpajdbctemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpajdbctemplate.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
