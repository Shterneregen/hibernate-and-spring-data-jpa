package random.jpajdbctemplate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import random.jpajdbctemplate.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
