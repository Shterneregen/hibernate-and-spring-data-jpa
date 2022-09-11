package random.jpajdbc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpajdbc.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
