package random.jpaspringdatajpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpaspringdatajpa.domain.Book;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByTitle(String title);
}
