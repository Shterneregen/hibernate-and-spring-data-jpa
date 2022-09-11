package random.jpaflyway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaflyway.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
