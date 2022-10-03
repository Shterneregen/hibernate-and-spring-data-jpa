package random.jpaspringdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaspringdatajpa.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
