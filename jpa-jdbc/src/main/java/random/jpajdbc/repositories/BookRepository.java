package random.jpajdbc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpajdbc.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
