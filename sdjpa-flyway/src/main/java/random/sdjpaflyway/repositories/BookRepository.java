package random.sdjpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.sdjpaflyway.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
