package random.sdjpaintro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.sdjpaintro.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
