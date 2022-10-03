package random.jpahibernatedao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpahibernatedao.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
